package com.spring.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0) // 数字越少优先级越高
public class SecurityAspect { // 安全切面
    // 切面 = 通知 + 切点

    // @Before("execution(* com.spring.service..*(..))")
    @Before("com.spring.service.LogAspect.通用切点表达式()")
    public void beforeAdvice() {
        System.out.println("####前置通知####");
    }

}
