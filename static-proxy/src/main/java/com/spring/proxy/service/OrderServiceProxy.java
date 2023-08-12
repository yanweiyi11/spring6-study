package com.spring.proxy.service;

// 代理对象（代理对象和目标对象要具有相同的行为，就要实现同样的接口）
// 客户端在使用代理对象的时候就像在使用目标对象一样
public class OrderServiceProxy implements OrderService {

    // 将目标对象作为代理对象的一个属性，这种关系叫做关联关系，比继承关系耦合度低
    // 代理对象中含有目标对象的引用，关联关系。
    // 注意：这里要写一个公共接口类型，因为公共接口耦合度低
    private OrderService target; // 目标对象。目标对象一定是实现了OrderService接口的

    // 创建代理对象的时候，传一个目标对象给代理对象
    public OrderServiceProxy(OrderService target) {
        this.target = target;
    }

    @Override
    public void generate() { // 代理方法
        // 增强
        long begin = System.currentTimeMillis();
        // 调用目标对象的目标方法
        target.generate();
        long end = System.currentTimeMillis();
        System.out.println("统计耗时" + (end - begin) + "毫秒");
    }

    @Override
    public void modify() { // 代理方法
        // 增强
        long begin = System.currentTimeMillis();
        // 调用目标对象的目标方法
        target.modify();
        long end = System.currentTimeMillis();
        System.out.println("统计耗时" + (end - begin) + "毫秒");
    }

    @Override
    public void detail() { // 代理方法
        // 增强
        long begin = System.currentTimeMillis();
        // 调用目标对象的目标方法
        target.detail();
        long end = System.currentTimeMillis();
        System.out.println("统计耗时" + (end - begin) + "毫秒");
    }
}
