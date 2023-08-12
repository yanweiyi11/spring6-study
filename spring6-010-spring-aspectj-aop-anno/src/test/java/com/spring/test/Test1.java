package com.spring.test;

import com.spring.service.Config;
import com.spring.service.OrderService;
import com.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    @Test
    public void t1() {
        // ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // UserService userService = context.getBean("userService", UserService.class);
        // userService.login();
        // userService.logout();

        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.generate();
    }
}
