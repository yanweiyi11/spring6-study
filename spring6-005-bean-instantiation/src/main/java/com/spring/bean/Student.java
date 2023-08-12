package com.spring.bean;

import java.util.Date;

public class Student {
    private Date birth;

    // Mon Oct 10 14:30:26 CST 2022
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "birth=" + birth +
                '}';
    }
}
