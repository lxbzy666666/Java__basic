package iotestdemo.outputstreamdemo.buffered;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author Gary luo
 * @Date 2021/2/2 16:13
 * @Version 1.0
 */
public class BufferedWriterTest {
    public static void main(String[] args) {
        String str = "";
        for (int i = 0; i < 10; i++) {
            str = str + (char)(Math.random()*26+'a');
        }
        FileWriter fileWriter=null;
        BufferedWriter bufferedWriter=null;
        try {
            fileWriter = new FileWriter("F:\\Java\\com\\valoroso\\base\\src\\main\\java\\iotestdemo\\FileTest\\BufferedWriterTest.txt",true);
            bufferedWriter=new BufferedWriter(fileWriter);
            //          此时数据存在缓存中还没有写入文件
            bufferedWriter.write(str);
//          将缓存的数据写入文件
            bufferedWriter.flush();
          System.out.println("succeeded");
        } catch (IOException e) {
            System.out.println("文件连接异常");
        }finally {
            //          关闭IO资源
            try {
                fileWriter.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
