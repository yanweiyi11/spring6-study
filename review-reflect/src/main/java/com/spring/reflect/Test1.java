package com.spring.reflect;

import java.security.KeyStore;

public class Test1 {
    public static void main(String[] args) {
        SomeService someService = new SomeService();

        /**
         * 调用一个方法，当中含有四要素：
         * 1.调用哪个对象
         * 2.方法名
         * 3.参数
         * 4.返回值
         *
         * 总结：调用哪个对象的哪个方法，传什么参数，返回什么值。
         * 即使是使用反射机制调用方法，也同样需要具备四要素
         */
        someService.doSome();

        String hello = someService.doSome("hello");
        System.out.println(hello);

        String print = someService.doSome("print", 100);
        System.out.println(print);
    }
}
