package com.spring.test;

import com.spring.bean.SpringBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringScopeTest {
    @Test
    public void t2(){
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean sb1 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                SpringBean sb1 = applicationContext.getBean("sb", SpringBean.class);
                System.out.println(sb1);
                SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
                System.out.println(sb2);
            }
        }).start();

        SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb2);
    }

    @Test
    public void t1(){
        /*
        * spring默认情况下bean是单例的
        * 在初始化spring上下文的时候实例化
        * 每一次调用getBean方法的时候，都返回那个单例的对象
        * 当讲bean的scope属性设置为prototype，bean是多例的
        * spring上下文初始化时并不会初始化这些bean
        * 每一次调用getBean方法的时候实例化该bean对象
        * prototype翻译为原型
        *
        * */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);
        SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb2);
        SpringBean sb3 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb3);
    }
}
