package com.spring.factory;

import com.spring.product.Tank;
import com.spring.product.Weapon;

/**
 * 具体工厂角色
 */
public class TankFactory extends WeaponFactory {
    @Override
    public Weapon get() {
        return new Tank();
    }
}
