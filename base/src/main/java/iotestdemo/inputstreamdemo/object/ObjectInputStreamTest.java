package iotestdemo.inputstreamdemo.object;

import iotestdemo.outputstreamdemo.object.Student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @Author Gary luo
 * @Date 2021/2/2 16:12
 * @Version 1.0
 * 读取ObjectOutputStreamTest.txt文件中的内容
 */
public class ObjectInputStreamTest {
    public static void main(String[] args) {
        ObjectInputStream objectInputStream=null;
        try {
            objectInputStream=new ObjectInputStream(new FileInputStream("F:\\Java\\com\\valoroso\\base\\src\\main\\java\\iotestdemo\\FileTest\\ObjectOutputStreamTest.txt"));
            Student student1 = (Student)objectInputStream.readObject();
            Student student2 = (Student)objectInputStream.readObject();
            System.out.println(student1);
            System.out.println(student2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
