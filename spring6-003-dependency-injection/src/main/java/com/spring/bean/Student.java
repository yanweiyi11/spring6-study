package com.spring.bean;

public class Student {
    private String name;
    private Clazz clazz;

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}
