package iotestdemo.inputstreamdemo.buffered;

import java.io.*;

/**
 * @Author Gary luo
 * @Date 2021/2/2 16:12
 * @Version 1.0
 * 读取BufferedOutputStreamTest.txt文件中内容
 */
public class BufferedInputStreamTest {
    public static void main(String[] args) {
        BufferedInputStream bufferedInputStream=null;
        try {
            bufferedInputStream=new BufferedInputStream(new FileInputStream("F:\\Java\\com\\valoroso\\base\\src\\main\\java\\iotestdemo\\FileTest\\BufferedOutputStreamTest.txt"));
            byte[] readbytes=new byte[1024];
            byte[] transfer=new byte[bufferedInputStream.read(readbytes)];
            for (int i = 0; i <transfer.length; i++) {
                transfer[i]=readbytes[i];
            }
            readbytes=null;
            System.out.println("Context is that:"+new String(transfer,"UTF-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
