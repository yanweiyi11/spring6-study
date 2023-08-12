package com.spring.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // 替代spring-config.xml文件
@ComponentScan("com.spring.service") // 组件扫描
@EnableAspectJAutoProxy(proxyTargetClass = true) // 启用AspectJ的自动代理
public class Config {
}
