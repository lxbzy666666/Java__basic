package iotestdemo.outputstreamdemo.object;

import java.io.Serializable;

/**
 * @Author Gary luo
 * @Date 2021/2/2 16:48
 * @Version 1.0
 * 需要进行序列化的类
 */
public class Student implements Serializable {
    private  String name;
    private  Integer age;
    private  Boolean working;

    public Student(String name, Integer age, Boolean working) {
        this.name = name;
        this.age = age;
        this.working = working;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", working=" + working +
                '}';
    }

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
