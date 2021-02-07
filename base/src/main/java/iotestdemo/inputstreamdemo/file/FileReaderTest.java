package iotestdemo.inputstreamdemo.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author Gary luo
 * @Date 2021/2/2 16:13
 * @Version 1.0
 * 读取FileWriterTest.txt
 */
public class FileReaderTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try{
            fileReader=new FileReader("F:\\Java\\com\\valoroso\\base\\src\\main\\java\\iotestdemo\\FileTest\\FileWriterTest.txt");
            char[] readchar=new char[1024];
            char[] readchar2=new char[fileReader.read(readchar)];
            for (int i = 0; i < readchar2.length; i++) {
                readchar2[i]=readchar[i];
            }
            readchar=null;
            System.out.println("Context is that:"+new String(readchar2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
