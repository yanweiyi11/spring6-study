package org.spring.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class SecurityLogAspect {

    @Pointcut("execution(* org.spring.service..save*(..))")
    public void savePointcut() {
    }

    @Pointcut("execution(* org.spring.service..del*(..))")
    public void delPointcut() {
    }

    @Pointcut("execution(* org.spring.service..upd*(..))")
    public void updPointcut() {
    }

    @Before("savePointcut() || delPointcut() || updPointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        // 系统时间
        Signature signature = joinPoint.getSignature();
        System.out.println(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +
                " zhangsan : " +
                signature.getDeclaringTypeName() +
                "." +
                signature.getName()
        );
    }

}
