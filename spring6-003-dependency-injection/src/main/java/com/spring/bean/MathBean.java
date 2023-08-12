package com.spring.bean;

public class MathBean {
    private String result;

    @Override
    public String toString() {
        return "MathBean{" +
                "result='" + result + '\'' +
                '}';
    }

    public void setResult(String result) {
        this.result = result;
    }
}
