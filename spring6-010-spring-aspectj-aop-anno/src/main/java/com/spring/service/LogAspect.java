package com.spring.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.weaver.ast.Var;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect // 切面类是需要使用@Aspect注解进行标注的
@Order(2)
public class LogAspect { // 切面类
    // 切面 = 通知 + 切点
    // 通知就是具体的增强代码
    // 通知Advice以方法的形式出现

    // 这个方法只是一个标记，方法名随意，方法体中也不需要写任何代码
    @Pointcut("execution(* com.spring.service..*(..))") // 定义通用的切点表达式
    public void 通用切点表达式() {}

    // @Before注解标注的方法，就是一个前置通知
    @Before("通用切点表达式()")
    public void beforeAdvice(JoinPoint joinPoint) {
        // 这个JoinPoint，在spring容器调用这个方法的时候，自动传入，可以直接用
        // 重点：joinPoint.getSignature() <- 获取目标方法的签名
        // 通过方法签名可以获取到一个方法的具体信息 -> public void generate
        // 例如获取目标方法的方法名
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("====前置通知====");
    }

    // 后置通知
    @AfterReturning("通用切点表达式()")
    public void afterReturningAdvice() {
        System.out.println("====后置通知====");
    }

    // 环绕通知（环绕是最大的范围）
    @Around("通用切点表达式()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // 前面代码
        System.out.println("====前环绕====");
        // 执行目标
        joinPoint.proceed();
        // 后面代码
        System.out.println("====后环绕====");
    }

    // 异常通知
    @AfterThrowing("通用切点表达式()")
    public void afterThrowingAdvice() {
        System.out.println("====异常通知====");
    }

    // 最终通知
    @After("通用切点表达式()")
    public void afterAdvice() {
        System.out.println("====最终通知====");
    }

}
