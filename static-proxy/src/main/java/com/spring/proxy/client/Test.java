package com.spring.proxy.client;

import com.spring.proxy.service.OrderService;
import com.spring.proxy.service.OrderServiceImpl;
import com.spring.proxy.service.OrderServiceImplSub;
import com.spring.proxy.service.OrderServiceProxy;

public class Test {
    public static void main(String[] args) {
        // OrderService orderService = new OrderServiceImpl();
        // OrderService orderService = new OrderServiceImplSub();
        // orderService.generate();
        // orderService.detail();
        // orderService.modify();

        // 创建目标对象
        OrderService target = new OrderServiceImpl();
        // 创建代理对象
        OrderService proxy = new OrderServiceProxy(target);
        // 调用代理对象的代理方法
        proxy.generate();
        proxy.modify();
        proxy.detail();
    }
}
