package threaddemo.wordcountfromfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @Author Gary luo
 * @Date 2021/2/2 8:56
 * @Version 1.0
 */
public  class ReadThread implements Callable<Map<String,Integer>> {
    /**
     * countmap  文件中每个单词出现的个数组成的map结构
     * filepath  文件路径
     */
    private  Map<String,Integer>countmap=new HashMap<>();
    private  String filepath=null;
    public ReadThread(String filepath){
        this.filepath=filepath;
    }
    public   void readContext() throws IOException {
        FileReader reader = new FileReader(filepath);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String result="";
        String s="";
        while ((s=bufferedReader.readLine())!=null){
            result+=s;
        }
        String[] strings = result.split(" ");
        //        对文件的内容进行map
            for (String s1 : strings) {
                if(!(s1.equals("")||s1.equals("\\r\\n"))){
                    if(countmap.containsKey(s1)){
                        countmap.put(s1,countmap.get(s1)+1);
                    }else {
                        countmap.put(s1,1);
                    }
                }
            }
    }

    @Override
    public Map<String, Integer> call() throws Exception {
        readContext();
        return countmap;
    }
}
