package com.spring.test;

import com.spring.bean.Student;
import com.spring.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void test2() {
        Student student = new Student();
        System.out.println(student);

        // 将自己new的对象纳入spring容器管理
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("student", student);

        // 从spring容器中获取
        Object bean = factory.getBean("student");
        System.out.println(bean);
    }

    @Test
    public void test1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("第八步，使用bean：" + user);
        // 必须手动关闭spring容器，这样spring容器才会销毁bean
        applicationContext.close();
    }
}
