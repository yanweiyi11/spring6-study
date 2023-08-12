package com.spring.client;

import com.spring.factory.FighterFactory;
import com.spring.factory.TankFactory;

public class Test {
    public static void main(String[] args) {
        FighterFactory f = new FighterFactory();
        TankFactory t = new TankFactory();

        System.out.println("f = " + f);
        System.out.println("t = " + t);
    }
}
