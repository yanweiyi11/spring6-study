package com.spring.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test4 {
    public static void main(String[] args) throws Exception {
        /**
         * 需求：假设现在已知以下信息：
         * 1.有这样一个类，类名叫做 com.spring.reflect.User
         * 2.这个类符合JavaBean规范。属性私有化，提供setter和getter方法
         * 3.这个类当中有一个属性，属性的名字叫做 age
         * 4.并且age的属性是int类型
         * 请使用反射机制，调用set方法给User对象的age属性赋值
         */
        Class<?> clazz = Class.forName("com.spring.reflect.User");
        Field field = clazz.getDeclaredField("age");
        Object obj = clazz.newInstance();
        Method setAgeMethod = clazz .getDeclaredMethod("setAge", field.getType());
        setAgeMethod.invoke(obj, 100);

        System.out.println(obj);
    }
}
