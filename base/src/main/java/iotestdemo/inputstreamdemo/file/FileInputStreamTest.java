package iotestdemo.inputstreamdemo.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author Gary luo
 * @Date 2021/2/2 16:12
 * @Version 1.0
 *
 * 读取FileTest文件夹下FileOutputStreamTest.txt文件
 */
public class FileInputStreamTest {
    public static void main(String[] args) {
        FileInputStream fileInputStream=null;
        try{
            fileInputStream=new FileInputStream(new File("F:\\Java\\com\\valoroso\\base\\src\\main\\java\\iotestdemo\\FileTest\\FileOutputStreamTest.txt"));
            byte[] readbytes=new byte[1024];
            byte[] transfer=new byte[fileInputStream.read(readbytes)];
            for (int i = 0; i <transfer.length; i++) {
                transfer[i]=readbytes[i];
            }
            readbytes=null;
            System.out.println("Context is that:"+new String(transfer,"UTF-8"));
        }catch (Exception e){
            System.out.println("read failed");
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
