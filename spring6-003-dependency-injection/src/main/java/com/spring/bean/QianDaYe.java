package com.spring.bean;

import java.util.Arrays;

public class QianDaYe {
    private String[] aiHaos;

    private Woman[] womens;

    @Override
    public String toString() {
        return "QianDaYe{" +
                "aiHaos=" + Arrays.toString(aiHaos) +
                ", womens=" + Arrays.toString(womens) +
                '}';
    }

    public void setWomens(Woman[] womens) {
        this.womens = womens;
    }

    public void setAiHaos(String[] aiHaos) {
        this.aiHaos = aiHaos;
    }

}
