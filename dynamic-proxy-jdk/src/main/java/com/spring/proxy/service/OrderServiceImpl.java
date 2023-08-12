package com.spring.proxy.service;

public class OrderServiceImpl implements OrderService { // 目标对象

    @Override
    public void generate() { // 目标方法
        // 模拟网络延迟
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单以生成");
    }

    @Override
    public void modify() { // 目标方法
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已修改");
    }

    @Override
    public void detail() { // 目标方法
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("展示订单详情");
    }

    @Override
    public String getName() {
        System.out.println("getName方法执行...");
        return "张三";
    }
}
