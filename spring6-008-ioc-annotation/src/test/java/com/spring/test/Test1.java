package com.spring.test;

import cn.spring.Spring6Config;
import cn.spring.service.StuService;
import com.spring.bean.Order;
import com.spring.bean.Student;
import com.spring.bean.User;
import com.spring.bean.Vip;
import com.spring.bean3.MyDataSource;
import com.spring.dao.OrderDao;
import org.junit.Test;
import org.spring.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void t6() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        StuService stuService = applicationContext.getBean("stuService", StuService.class);
        stuService.delStu();
    }
    @Test
    public void t5() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring5.xml");
        StuService stuService = applicationContext.getBean("stuService", StuService.class);
        stuService.delStu();
    }
    @Test
    public void t4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring4.xml");
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }

    @Test
    public void t3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring3.xml");
        MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);

        com.spring.bean3.User user = applicationContext.getBean("user", com.spring.bean3.User.class);
        System.out.println(user);
    }

    @Test
    public void v2() {
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("spring2.xml");

    }

    @Test
    public void t1() {
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = application.getBean("userBean", User.class);
        Vip vipBean = application.getBean("vipBean", Vip.class);
        Order orderBean = application.getBean("order", Order.class);
        Student studentBean = application.getBean("student", Student.class);

        OrderDao orderDao = application.getBean("orderDao", OrderDao.class);

        System.out.println(userBean);
        System.out.println(vipBean);
        System.out.println(orderBean);
        System.out.println(studentBean);
        System.out.println(orderDao);
    }
}
