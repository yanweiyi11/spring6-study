package org.spring.proxy.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EnhanceInvocationHandler implements InvocationHandler { // 调用处理器
    private Object target;

    public EnhanceInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy  代理对象
     * @param method 目标方法
     * @param args   目标方法上的参数
     * @return 目标方法的执行结果
     * @throws Throwable 抛出的所有异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 编写增强代码
        System.out.println(">>>我变秃了，也变强了<<<");
        Object result = method.invoke(target, args);
        System.out.println(">>>增强结束<<<");
        return result;
    }

}
