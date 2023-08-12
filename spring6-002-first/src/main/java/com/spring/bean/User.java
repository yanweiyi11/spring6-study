package com.spring.bean;

/**
 * Bean
 */
public class User {
    public User() { // 默认情况下，spring会通过反射机制，调用类的无参构造实例对象
        System.out.println("user...");
    }
}
