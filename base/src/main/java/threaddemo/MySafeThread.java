package threaddemo;

/**
 * @Author Gary luo
 * @Date 2021/2/1 16:00
 * @Version 1.0
 */
class MySafeThread extends  Thread{
    @Override
    public void run() {
        MyResources.minusOne();
    }
}
