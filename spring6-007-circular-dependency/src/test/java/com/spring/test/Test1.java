package com.spring.test;

import com.spring.bean.Husband;
import com.spring.bean.Wife;
import com.sun.jdi.VoidValue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void t2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println(husband);
        System.out.println(wife);
    }
    @Test
    public void t1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println(husband);
        System.out.println(wife);
    }
}
