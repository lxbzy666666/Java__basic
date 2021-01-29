package reflectiondemo;

/**
 * @Author Gary luo
 * @Date 2021/1/29 15:26
 * @Version 1.0
 * 要被调用私有属性和私有方法的类
 */
public class Person {
    private  String name;
    private  Integer age;
    private  Boolean  working;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public Boolean getWorking() {
        return working;
    }

    public void setWorking(Boolean working) {
        this.working = working;
    }
}
