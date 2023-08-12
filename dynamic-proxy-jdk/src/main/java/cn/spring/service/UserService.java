package cn.spring.service;

public class UserService {
    public void do1() {
        System.out.println("do 1");
    }

    public void do2() {
        System.out.println("do 2");
    }

    public void do3() {
        System.out.println("do 3");
    }

    public void do4() {
        System.out.println("do 4");
    }

    public void do5() {
        System.out.println("do 5");
    }

    // 核心业务方法

    /**
     * 1.连接点描述的是位置
     * 2.切点本质的就是方法（真正织入切面的那个方法叫做切点）
     * 3.通知就是具体的增强代码
     * 4.切面：切点 + 通知
     */
    public void service() {
        try {
            // 连接点
            do1(); // 切点
            // 连接点
            do2(); // 切点
            // 连接点
            do3(); // 切点
            // 连接点
            do5(); // 切点
            // 连接点
        } catch (Exception e) {
            // 连接点
            e.printStackTrace();
        }
    }
}