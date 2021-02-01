package threaddemo;

/**
 * @Author Gary luo
 * @Date 2021/2/1 15:34
 * @Version 1.0
 */
class MyThread extends  Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        MyResources.num--;
    }
}
