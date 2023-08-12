package com.spring.proxy.client;

import com.spring.proxy.service.OrderService;
import com.spring.proxy.service.OrderServiceImpl;
import com.spring.proxy.util.ProxyUtil;
import com.spring.proxy.util.TimerInvocationHandler;

import java.lang.reflect.Proxy;

public class Test { // 客户端程序
    public static void main(String[] args) {
        // 创建目标对象
        OrderService target = new OrderServiceImpl();
        // 创建代理对象
        /*
        1.newProxyInstance 翻译为：新建代理对象
            也就是说通过调用这个方法，可以创建代理对象
            本质上，这个Proxy.newProxyInstance()方法的执行做了两件事
                第一件事：在内存中动态的生成了一个代理类的字节码Class
                第二件事：new对象了，通过在内存中生成的代理类代码，实例化了代理对象
        2.关于newProxyInstance()方法的三个重要的参数：
            第一个参数：ClassLoader loader
                类加载器。作用：在内存当中生成的字节码，也是class文件，要执行也得先加载到内存当中，加载类就需要类加载器，所以需要类加载器
                并且jdk要求，目标类和代理类的类加载器必须使用同一个
            第二个参数：Class<?>[] interfaces
                代理类和目标类要实现同一个接口或同一些接口
                在内存中生成代理类的时候，这个代理类是需要你告诉它实现那些接口的
            第三个参数：InvocationHandler h
                InvocationHandler 翻译为：调用处理器。是一个接口
                在调用处理器接口中编写的就是增强代码
                因为具体要增强什么代码，jdk动态代理技术它是猜不到的
                既然是接口，就要写实现类，这种调用处理器只用写一次，不会类爆炸
        注意：代理对象和目标对象实现的接口一样，所以可以向下转型
         */
        /*OrderService proxyOcj = (OrderService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TimerInvocationHandler(target)
                );*/
        OrderService proxyObj = (OrderService) ProxyUtil.getProxy(target);
        // 调用代理对象的代理方法
        proxyObj.generate();
        proxyObj.modify();
        proxyObj.detail();

        String name = proxyObj.getName();
        System.out.println(name);
    }
}
