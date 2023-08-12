package com.spring.service;

import com.spring.dao.OtherDao;

public class OtherService {
    private OtherDao otherDao;

    public void setOtherDao(OtherDao otherDao) {
        this.otherDao = otherDao;
    }

    public void generate() {
        otherDao.insert();
    }
}
