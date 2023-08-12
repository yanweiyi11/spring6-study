package com.spring.proxy.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 专门负责计时的调用处理器对象
 * 在调用处理器当中编写计时相关的增强代码
 * 这个调用处理器只需要写一个就行了
 */
public class TimerInvocationHandler implements InvocationHandler {

    // 目标对象
    private Object target;

    public TimerInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 1.为什么强行要求必须实现InvocationHandler接口
     *  因为一个类实现接口就必须实现接口中的方法
     *  以下这个方法必须是invoke，因为jdk在底层调用invoke方法的程序已经提前写好了
     *  注意：invoke方法不是程序员负责调用的，是jdk负责调用的
     * 2.invoke方法什么时候被调用呢？
     *  当代理对象调用代理方法的时候，注册在InvocationHandler调用处理器当中的invoke方法被调用
     * 3.invoke方法的3个参数：
     *  invoke方法是jdk调用的，所以jdk调用这个方法的时候，会自动给我们传过来这3个参数
     *  我们可以在invoke方法的大括号中直接使用
     *  proxy：代理对象
     *  method：目标对象的目标方法
     *  args：方法上的参数
     * invoke方法执行过程中，使用method来调用目标对象的目标方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 编写增强代码
        long begin = System.currentTimeMillis();

        Object ret = method.invoke(target, args);

        long end = System.currentTimeMillis();
        System.out.println("消耗了" + (end - begin) + "毫秒");
        return ret;
    }
}
