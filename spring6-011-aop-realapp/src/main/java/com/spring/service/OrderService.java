package com.spring.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService { // 目标对象
    // 生成订单的业务方法
    public void generate() { // 目标方法
        System.out.println("正在生成订单...");
        System.out.println(1/0);
    }

    // 取消订单的业务方法
    public void cancel() { // 目标方法
        System.out.println("订单已取消...");
    }

}
