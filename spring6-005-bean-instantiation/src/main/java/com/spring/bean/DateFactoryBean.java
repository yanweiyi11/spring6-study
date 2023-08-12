package com.spring.bean;

import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFactoryBean implements FactoryBean<Date> {
    private String strDate;

    public DateFactoryBean(String strDate) {
        this.strDate = strDate;
    }

    @Override
    public Date getObject() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.parse(strDate);
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
