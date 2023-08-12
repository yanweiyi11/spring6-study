package com.spring.client;

import com.spring.annotation.Component;

public class ReflectAnnotationTest1 {
    public static void main(String[] args) throws Exception {
        // 通过反射机制怎么读取注解
        Class<?> clazz = Class.forName("com.spring.bean.User");
        if (clazz.isAnnotationPresent(Component.class)) {
            // 获取类上的注解
            Component annotation = clazz.getAnnotation(Component.class);
            // 访问注解属性
            System.out.println(annotation.value());
        }
    }
}
