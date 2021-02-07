package iotestdemo.outputstreamdemo.file;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author Gary luo
 * @Date 2021/2/2 16:13
 * @Version 1.0
 * 将随机字符串输出到FileTest文件夹下
 */
public class FileWriterTest {
    public static void main(String[] args) {
        String str = "";
        for (int i = 0; i < 10; i++) {
            str = str + (char)(Math.random()*26+'a');
        }
        try {
            FileWriter fileWriter = new FileWriter("F:\\Java\\com\\valoroso\\base\\src\\main\\java\\iotestdemo\\FileTest\\FileWriterTest.txt",true);
//          此时数据存在缓存中还没有写入文件
            fileWriter.write(str);
//          将缓存的数据写入文件
            fileWriter.flush();
//          关闭IO资源
            fileWriter.close();
            System.out.println("succeeded");
        } catch (IOException e) {
            System.out.println("文件连接异常");
        }
    }
}
