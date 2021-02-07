package iotestdemo.inputstreamdemo.buffered;

import java.io.*;

/**
 * @Author Gary luo
 * @Date 2021/2/2 16:13
 * @Version 1.0
 * 读取BufferedWriterTest.txt文件中的内容
 */
public class BufferedReaderTest {
    public static void main(String[] args) {
        BufferedReader bufferedReader=null;
        try{
            bufferedReader=new BufferedReader(new FileReader("F:\\Java\\com\\valoroso\\base\\src\\main\\java\\iotestdemo\\FileTest\\BufferedWriterTest.txt"));
            String context=null;
            while ((context=bufferedReader.readLine())!=null){
                System.out.println("Context is that:"+context);
            }

        }catch (Exception e){
            System.out.println("read failed");
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
