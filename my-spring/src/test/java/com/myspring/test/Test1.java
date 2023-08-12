package com.myspring.test;

import com.myspring.bean.UserService;
import org.junit.Test;
import org.myspringframework.core.ApplicationContext;
import org.myspringframework.core.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void t1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring.xml");
        Object user = applicationContext.getBean("user");
        Object userDao = applicationContext.getBean("userDao");
        UserService userService = (UserService) applicationContext.getBean("userService");

        System.out.println(user);
        userService.save();
    }
}
