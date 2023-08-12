package com.spring.factory;

import com.spring.product.Fighter;
import com.spring.product.Weapon;

/**
 * 具体工厂角色
 */
public class FighterFactory extends WeaponFactory{

    @Override
    public Weapon get() {
        return new Fighter();
    }
}
