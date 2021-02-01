package threaddemo;

/**
 * @Author Gary luo
 * @Date 2021/2/1 15:17
 * @Version 1.0
 */
public class MyResources {
    public  static  int num=1000;

    /**
     * 对num减一
     */
    public  static  synchronized void minusOne(){
         num--;
    }
}
