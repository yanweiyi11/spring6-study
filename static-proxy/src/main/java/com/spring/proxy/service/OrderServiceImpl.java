package com.spring.proxy.service;

public class OrderServiceImpl implements OrderService { // 目标对象
    /**
     * 项目经理提出一个新的需求：要统计所有业务接口中，每一个业务方法的耗时
     * 解决方案一：硬编码，在每一个业务接口中的每一个业务方法中，直接添加统计耗时的程序。
     *    缺点一：违背OCP开闭原则
     *    缺点二：代码没有得到复用，相同代码写了很多遍
     * 解决方案二：编写OrderServiceImpl类的子类，让子类继承业务类，对每个业务方法进行重写。
     *    缺点一：虽然解决了OCP开闭原则，但是这种方式，会导致耦合度很高，因为采用了继承关系。继承关系是一种耦合度非常高的关系，不建议使用
     *    缺点二：代码没有得到复用，相同代码写了很多遍
     * 解决方案三：代理模式
     *    优点一：解决了OCP
     *    优点二：采用代理模式的has a，可以降低耦合度
     *    缺点：目前使用的是静态代理，静态代理的缺点是
     *      类爆炸。假设系统中有1000个接口，那么每个接口都有一个代理类，这样类会急剧膨胀，不好维护
     *      怎么解决类爆炸问题？使用动态代理，动态代理还是代理模式，只不过添加了字节码生成技术，可以在内存中为我们动态的生成一个class字节码，字节码就是代理类
     *      在内存中动态的生成字节码代理类的技术，叫做动态代理
     *
     */
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
}
