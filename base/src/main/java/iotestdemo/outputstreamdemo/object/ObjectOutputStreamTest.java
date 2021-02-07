package iotestdemo.outputstreamdemo.object;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Author Gary luo
 * @Date 2021/2/2 16:12
 * @Version 1.0
 * 将实现了Serializable接口的类通过objectOutputStream流输出到文件中
 */
public class ObjectOutputStreamTest {
    public static void main(String[] args) {
        Student student1 = new Student("张三",22,true);
        Student student2 = new Student("李四",19,false);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream=null;
        try {
            fileOutputStream = new FileOutputStream("F:\\Java\\com\\valoroso\\base\\src\\main\\java\\iotestdemo\\FileTest\\ObjectOutputStreamTest.txt", false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student1);
            objectOutputStream.writeObject(student2);
            System.out.println("succeeded");
        } catch (FileNotFoundException e) {
            System.out.println("文件找不到");
        } catch (IOException e) {
            System.out.println("对象流创建异常");
        }finally {
            try {
                fileOutputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
