package iotestdemo.outputstreamdemo.buffered;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author Gary luo
 * @Date 2021/2/2 16:12
 * @Version 1.0
 */
public class BufferedOutputStreamTest {
    public static void main(String[] args) {
        String str = "";
        for (int i = 0; i < 10; i++) {
            str = str + (char)(Math.random()*26+'a');
        }
        FileOutputStream fileOutputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        try {
            /*
             *第一个参数为文件的路径，不存在且无法创建才会报FileNotFoundException异常
             *第二个参数true表示将内容追加到文件中，false表示覆盖
             * */
            fileOutputStream = new FileOutputStream("F:\\Java\\com\\valoroso\\base\\src\\main\\java\\iotestdemo\\FileTest\\BufferedOutputStreamTest.txt",true);
            bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
//            将字符串写进文本
            bufferedOutputStream.write(str.getBytes());
//            将缓存中的数据刷新到文本中
            bufferedOutputStream.flush();
            System.out.println("succeeded");
        } catch (FileNotFoundException e) {
            System.out.println("文件找不到");
        } catch (IOException e) {
            System.out.println("内容插入过程异常");
        }finally {
            try {
                fileOutputStream.close();
                bufferedOutputStream.close();
            } catch (IOException e) {
                System.out.println("IO资源关闭异常");
            }
        }
    }
}
