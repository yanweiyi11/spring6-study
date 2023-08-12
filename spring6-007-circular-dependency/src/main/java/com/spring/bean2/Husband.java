package com.spring.bean2;

public class Husband {
    private String name;
    private Wife wife;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Husband{" +
                "name='" + name + '\'' +
                ", wife=" + wife.getName() +
                '}';
    }

    public Husband(String name, Wife wife) {
        this.name = name;
        this.wife = wife;
    }
}
