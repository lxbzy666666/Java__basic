package threaddemo.wordcountfromfile;

import java.io.File;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author Gary luo
 * @Date 2021/2/1 16:50
 * @Version 1.0
 */
public class WordCountTest {
    private static String filepath="F:/Java/com/valoroso/base/src/main/java/threaddemo/countfile/";
    private static Map<String,Integer>map=null;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        writeToFile();
        wordCountFromFiles();
    }

    /**
     * @throws InterruptedException
     * 将随机单词组成的内容通过多线程写进指定文件目录
     */
    public static  void  writeToFile() throws InterruptedException {
             for (int i = 0; i < 10; i++) {
            new WriteThread(filepath+i).start();
        }
        Thread.sleep(1000);
        System.out.println("Multiple file writing succeeded");
    }

    /**
     * 使用多线程多指定文件夹下所有文件内容进行WordCount
     */
    public static  void  wordCountFromFiles() throws ExecutionException, InterruptedException {
        List<Map<String,Integer>>mapList=new ArrayList<>();
//        获取指定文件夹下所有文件
        File allfile = new File(filepath);
        File[] files = allfile.listFiles();
        for (int i = 0; i <files.length ; i++) {
//          通过FutureTask获取线程返回的wordcount
            ReadThread readThread = new ReadThread(filepath + files[i].getName());
            FutureTask<Map<String, Integer>> task = new FutureTask<>(readThread);
            new Thread(task).start();
//          将每个线程读取到的单词的wordcount添加到List集合中
            mapList.add(task.get());
        }
        map=mapList.get(0);
//        将List中第一map与其他map进行合并：先将key相同的valueX相加，在后面的map中删除，最后合并
        for (int i = 1; i < mapList.size(); i++) {
            Map<String, Integer> map1 = mapList.get(i);
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                if(map1.containsKey(next)){
                    //将后面的map中重复的元素进行合并
                    map.put(next,map.get(next)+map1.get(next));
                    //将重复元素删除
                    map1.remove(next);
                }
            }
            //合并两个map
            map.putAll(map1);
        }
//        打印合并后的结果
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" :"+entry.getValue()+"   ");
        }
    }
}
