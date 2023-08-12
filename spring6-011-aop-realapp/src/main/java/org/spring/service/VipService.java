package org.spring.service;

import org.springframework.stereotype.Service;

@Service
public class VipService {
    public void saveVip() {
        System.out.println("新增会员信息...");
    }

    public void delVip() {
        System.out.println("删除会员信息...");
    }

    public void updVip() {
        System.out.println("修改会员信息...");
    }

    public void selVip() {
        System.out.println("查看会员信息...");
    }
}
