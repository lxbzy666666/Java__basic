package threaddemo;

/**
 * @Author Gary luo
 * @Date 2021/2/1 15:34
 * @Version 1.0
 */
class MyUnSafeThread extends  Thread{
    @Override
    public void run() {
        MyResources.num--;
        System.out.println(Thread.currentThread().getName()+"修改后："+MyResources.num);
    }
}
