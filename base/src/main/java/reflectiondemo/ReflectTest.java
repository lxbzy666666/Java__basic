package reflectiondemo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author Gary luo
 * @Date 2021/1/29 15:24
 * @Version 1.0
 *
 */
public class ReflectTest {
    private static  Class personclass=null;
    private static Object o=null;
    public static void main(String[] args) throws Exception {
        personclass = Class.forName("reflectiondemo.Person");
        o = personclass.newInstance();
        if(setFiles()){
            if (!transferMethod()){
                System.out.println("调用私有方法失败");
            }
        }else {
            System.out.println("修改私有属性失败");
        }
    }

    /**
     * 修改Person类的私有属性，成功则返回true,否则返回false
     */
    public static boolean setFiles(){
        try {

//                获取类的指定属性
            Field namefiled = personclass.getDeclaredField("name");
//                取消属性的语法检查
            namefiled.setAccessible(true);
//                修改私有属性默认值
            namefiled.set(o,"北京");
            return  true;
        } catch (IllegalAccessException e) {
            System.out.println("不能改变属性的语法检查");
            return  false;
        } catch (NoSuchFieldException e) {
            System.out.println("找不到属性");
            return  false;
        }
    }

    /**
     * @return  调用Person对象的私有方法，成功则返回true,否则返回false
     */
    public static boolean transferMethod(){
        try {
//            获取方法对象
            Method method = personclass.getDeclaredMethod("showAll",  null);
//            修改对象的语法检查
            method.setAccessible(true);
            method.invoke(o,  null);
        } catch (NoSuchMethodException e) {
            System.out.println("没有这个方法");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  true;
    }
}
