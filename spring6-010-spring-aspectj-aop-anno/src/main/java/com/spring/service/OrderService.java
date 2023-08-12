package com.spring.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService { // 目标对象
    public void generate() { // 目标方法
        System.out.println("----生产订单----");
        // System.out.println(1/0);
    }
}
