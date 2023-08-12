package com.spring.factory;

import com.spring.product.Fighter;
import com.spring.product.Tank;
import com.spring.product.Weapon;

public class WeaponFactory {
    public static Weapon get(String type) {
        switch (type) {
            case "F":
                return new Fighter();
            case "T":
                return new Tank();
            default:
                throw new RuntimeException("没有这个类");
        }
    }
}
