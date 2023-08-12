package com.spring.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {
    private List<String> names;
    private Set<String> addrs;
    private Map<Integer, String> phones;
    private Properties properties;

    @Override
    public String toString() {
        return "Person{" +
                "names=" + names +
                ", addrs=" + addrs +
                ", phones=" + phones +
                ", properties=" + properties +
                '}';
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setPhones(Map<Integer, String> phones) {
        this.phones = phones;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setAddrs(Set<String> addrs) {
        this.addrs = addrs;
    }
}
