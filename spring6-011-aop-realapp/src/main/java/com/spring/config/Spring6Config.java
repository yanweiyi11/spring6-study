package com.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.spring.service")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Spring6Config {
}
