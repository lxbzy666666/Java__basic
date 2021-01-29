package reflectiondemo;

import sun.nio.cs.ext.GBK;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Gary luo
 * @Date 2021/1/29 15:24
 * @Version 1.0
 *
 * 目的：
 * 通过反射实现自动注入
 * 解决步骤：
 * 1.通过反射获取类的字节码对象(三种方式)
 *   1.1  Class.forName("XXXX")  传入类的全限定名称
 *   1.2  XXXX.class          全限定类名.class
 *   1.3  类实例.getClass()    通过该类的实例获取
 * 2.通过字节码对象操作属性和方法
 */
public class Change {
    public static void main(String[] args) throws Exception {
        Reflect("reflectiondemo.Person");
    }
    public  static  void  Reflect(String classname) throws Exception {
        autowiredByReflect(classname);
    }
    public  static  boolean  isInteger(String p){
        char[] chars = p.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(!Character.isDigit(chars[i])){
                return  false;
            }
        }
        return  true;
    }
    /**
     * 将传入的属性和值封装为map
     */
    public  static  void  autowiredByReflect(String classname) throws Exception {
        Map<String,Object>map=new HashMap<>();
        Properties properties = new Properties();
        InputStreamReader reader = new InputStreamReader(Object.class.getResourceAsStream("/Person.properties"), "GBK");
        properties.load(reader);
        for (String propertyName : properties.stringPropertyNames()) {
            String property = properties.getProperty(propertyName);
            if(isInteger(property)){
                map.put(propertyName,Integer.parseInt(property));
            }
            else if(property.equals("true")||property.equals("false")){
                map.put(propertyName,Boolean.valueOf(property));
            }else {
            map.put(propertyName,property);}
        }
        byReflect(classname,map);
    }

    /**
     * 通过反射操作
     */
    public static  void  byReflect(String classname, Map<String,Object>map) throws Exception {
        //获取对象的字节码对象personclass
        Class<?> personclass = Class.forName(classname);
        Person instance = (Person) personclass.newInstance();
        //获取属性
        BeanInfo beanInfo = Introspector.getBeanInfo(personclass);
        List<PropertyDescriptor> propertyDescriptors = Arrays.stream(beanInfo.getPropertyDescriptors()).filter(p -> {
            return !"class".equals(p.getName()) && !"id".equals(p.getName());
        }).collect(Collectors.toList());
        //遍历属性进行赋值
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            if(map.containsKey(propertyDescriptor.getName())){
                propertyDescriptor.getWriteMethod().invoke(instance, map.get(propertyDescriptor.getName()));
                System.out.println(propertyDescriptor.getReadMethod().invoke(instance));

            }
        }
    }
}
