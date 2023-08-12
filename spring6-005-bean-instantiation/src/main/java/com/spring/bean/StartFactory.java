package com.spring.bean;

public class StartFactory {

    public static Start get(){
        // 这个start对象最终实际上创建的时候还是我们负责new的对象
        return new Start();
    }

}
