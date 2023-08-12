package com.spring.bean2;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
public class A {
    public A() {
        System.out.println("A...");
    }
}

@Controller
class B {
    public B() {
        System.out.println("B...");
    }
}

@Service
class C {
    public C() {
        System.out.println("C...");
    }
}

@Repository
class D {
    public D() {
        System.out.println("D...");
    }
}

@Controller
class E {
    public E() {
        System.out.println("E...");
    }
}
