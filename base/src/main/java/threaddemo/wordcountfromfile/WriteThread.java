package threaddemo.wordcountfromfile;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author Gary luo
 * @Date 2021/2/1 16:52
 * @Version 1.0
 */
public class WriteThread extends  Thread{

    /**
     * filePath   写入文件的路径
     */
    private  String filePath=null;
    public WriteThread(String filePath){
        this.filePath=filePath;
    }
    @Override
    public void run() {
        saveAsFile(randomContext());
    }

    /**
     * @param context 写入文件中的内容
     * 将随机单词组成的内容保存到文件中
     */
    void  saveAsFile(String context){
        FileWriter fwriter = null;
        try {
            // true表示不覆盖原来的内容，而是加到文件的后面
            fwriter = new FileWriter(filePath, true);
            fwriter.write(context);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    /**
     * @return  返回由随机单词组成的内容
     */
    String  randomContext(){
        String words=null;
        for (int i = 0; i <(int)(100*Math.random()); i++) {
            if(words==null){
                words=createRandomWord();
            }else {
                words+=" "+createRandomWord();
            }
        }
        return  words;
    }
    /**
     * 生成随机单词
     */
    String  createRandomWord(){
        //需要生成几位
        int n = (int)(10*Math.random());
        //最终生成的字符串
        String str = "";
        for (int i = 0; i < n; i++) {
            str = str + (char)(Math.random()*26+'a');
        }

        return  str;
    }
}
