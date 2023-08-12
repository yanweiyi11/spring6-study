package com.spring.client;

import com.spring.annotation.Component;

import javax.xml.transform.sax.SAXResult;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ComponentScan {
    public static void main(String[] args) {
        Map<String, Object> beanMap = new HashMap<>();
        // 目前只知道一个包的名字，扫描这个包下所有的类，当这个类上有Component注解的时候，实例化这个对象，放到map集合中
        String packageName = "com.spring.bean";
        // 扫描程序
        String packagePath = packageName.replaceAll("\\.", "/");
        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        String path = url.getPath();
        // 获取绝对路径下的所有文件
        File file = new File(path);
        File[] files = file.listFiles();
        Arrays.stream(files).forEach(f -> {
            String className = packageName + "." + f.getName().split("\\.")[0];
            // System.out.println(className);
            // 通过反射机制解析注解
            try {
                Class<?> aClass = Class.forName(className);
                // 判断类上是否有注解
                if (aClass.isAnnotationPresent(Component.class)) {
                    // 获取注解
                    Component annotation = aClass.getAnnotation(Component.class);
                    String id = annotation.value();
                    Object obj = aClass.newInstance();
                    beanMap.put(id, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(beanMap);
    }
}
