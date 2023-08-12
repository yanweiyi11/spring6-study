package com.spring.client;

import com.spring.factory.WeaponFactory;
import com.spring.product.Weapon;

public class Test {
    public static void main(String[] args) {
        Weapon f = WeaponFactory.get("F");
        Weapon t = WeaponFactory.get("T");

        System.out.println("f = " + f);
        System.out.println("t = " + t);
    }
}
