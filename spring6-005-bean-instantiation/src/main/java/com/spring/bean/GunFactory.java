package com.spring.bean;

/**
 * 具体工厂角色
 */
public class GunFactory {
    public Gun get() {
        return new Gun();
    }
}
