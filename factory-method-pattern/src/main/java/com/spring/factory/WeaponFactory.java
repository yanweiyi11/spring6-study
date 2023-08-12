package com.spring.factory;

import com.spring.product.Weapon;

/**
 * 抽象工厂角色
 */
public abstract class WeaponFactory {
    public abstract Weapon get();
}
