package com.spring.test;

import com.spring.config.Spring6Config;
import com.spring.service.AccountService;
import com.spring.service.OrderService;
import org.junit.Test;
import org.spring.service.UserService;
import org.spring.service.VipService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    @Test
    public void t2() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(org.spring.config.Spring6Config.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        VipService vipService = applicationContext.getBean("vipService", VipService.class);

        userService.saveUser();
        userService.delUser();
        userService.updUser();
        userService.selUser();

        System.out.println("=================================");

        vipService.saveVip();
        vipService.delVip();
        vipService.updVip();
        vipService.selVip();
    }
    @Test
    public void t1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        accountService.transfer();
        accountService.withdraw();
        orderService.generate();
        orderService.cancel();
    }
}
