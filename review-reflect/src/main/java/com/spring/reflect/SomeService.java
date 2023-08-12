package com.spring.reflect;

public class SomeService {
    public void doSome() {
        System.out.println("public void doSome() 执行");
    }

    public String doSome(String s) {
        System.out.println("public String doSome(String s) 执行");
        return s;
    }

    public String doSome(String s, Integer i) {
        System.out.println("public String doSome(String s, Integer i) 执行");
        return s + i.toString();
    }
}
