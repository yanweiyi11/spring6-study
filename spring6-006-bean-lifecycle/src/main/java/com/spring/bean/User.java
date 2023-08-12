package com.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class User implements
        BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean {
    private String name;

    public User() {
        System.out.println("第一步，无参构造执行");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("第二部，给对象属性赋值");
    }

    public void initBean() {
        System.out.println("第六步，初始化bean");
    }

    public void destroyBean() {
        System.out.println("第十步，销毁bean");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("第三步，Bean这个类的加载器：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("第三步，生产这个bean的工厂对象是：" + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("第三步，这个bean的名字是：" + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("第五步，InitializingBean.afterPropertiesSet 执行");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("第九步，DisposableBean.destroy 执行");
    }
}
