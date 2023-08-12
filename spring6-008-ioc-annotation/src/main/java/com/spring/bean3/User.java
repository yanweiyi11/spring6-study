package com.spring.bean3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
    // @Value("giao")
    // private String name;
    // @Value("18")
    // private int age;

    private String name;
    private int age;

    // @Value注解也可以使用在方法上
    // @Value("giao2")
    // public void setName(String name) {
    //     this.name = name;
    // }
    // @Value("19")
    // public void setAge(int age) {
    //     this.age = age;
    // }

    public User(@Value("giao3") String name, @Value("20") int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
