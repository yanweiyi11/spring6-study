package com.spring.reflect;

import java.lang.reflect.Method;

public class Test3 {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.spring.reflect.SomeService");
        Method doSomeMethod = aClass.getDeclaredMethod("doSome");
        // 四要素：对象 方法名 参数 返回值
        Object obj = aClass.newInstance();
        doSomeMethod.invoke(obj);
    }
}
