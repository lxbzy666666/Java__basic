package reflectiondemo;

/**
 * @Author Gary luo
 * @Date 2021/1/29 15:26
 * @Version 1.0
 */
public class Person {
    private  String name="成都";
    public   Integer age=21;
    public   Boolean  working=true;
    public String getName() {
        return name;
    }
    public Boolean getWorking() {
        return working;
    }
    public Integer getAge() {
        return age;
    }
    private  void showAll(){
        System.out.println("名称:"+getName()+"  年龄:"+getAge()+"  是否工作:"+getWorking());
    }
}
