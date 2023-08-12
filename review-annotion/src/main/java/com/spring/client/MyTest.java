package com.spring.client;

import com.spring.annotation.Component;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyTest {
    public static void main(String[] args) {
        Map beanMap = new HashMap();
        String packageName = "com.spring.bean";
        String packagePath = packageName.replaceAll("\\.", "/");
        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        File file = new File(url.getPath());
        File[] files = file.listFiles();
        Arrays.stream(files).forEach(f -> {
            String p = packageName + "." + f.getName().split("\\.")[0];
            try {
                Class<?> aClass = Class.forName(p);
                if (aClass.isAnnotationPresent(Component.class)) {
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
