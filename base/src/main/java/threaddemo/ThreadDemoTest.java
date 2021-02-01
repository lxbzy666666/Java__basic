package threaddemo;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Gary luo
 * @Date 2021/2/1 15:19
 * @Version 1.0
 */
public class ThreadDemoTest {
    public static void main(String[] args) throws InterruptedException {
//        notSageModify()
        safeModify();
        Thread.sleep(1000);
        System.out.println("最终多线程修改后的值："+MyResources.num);
    }

    /**
     *   开启100个线程对临界资源num=1000进行修改（不安全）：
     *   如果线程安全则结果为900，如果存在结果不为900则表示不安全
     */
    public  static  void  notSageModify() throws InterruptedException {
        for (int i = 0; i <100; i++) {
            new MyUnSafeThread().start();
        }
    }

    /**
     *开启100个线程对临界资源num=1000进行修改（安全）：
     * 将线程中修改资源的方法使用Synchornize进行修饰，监视器为临界资源类对象
     */
    public  static  void   safeModify(){
        for (int i = 0; i <100; i++) {
            new MySafeThread().start();
        }
    }

}
