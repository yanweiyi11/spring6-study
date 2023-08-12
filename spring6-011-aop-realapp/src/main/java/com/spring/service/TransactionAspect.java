package com.spring.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionAspect {

    @Pointcut("execution(* com.spring.service..*(..))")
    public void pc(){}

    @Around("pc()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) {
        try {
            // 前环绕
            System.out.println("开启事务");
            // 执行目标
            joinPoint.proceed();
            //后环绕
            System.out.println("提交事务");
        } catch (Throwable e) {
            System.out.println("回滚事务");
        }
    }
}
