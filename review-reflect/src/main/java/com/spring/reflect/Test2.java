package com.spring.reflect;

import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.spring.reflect.SomeService");
        Method doSomeMethod = clazz.getDeclaredMethod("doSome", String.class, Integer.class);
        Object obj = clazz.newInstance();
        Object print = doSomeMethod.invoke(obj, "print", 100);
        System.out.println(print);
    }
}
