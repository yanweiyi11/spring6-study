package com.spring.proxy.service;

import java.util.concurrent.TransferQueue;

/**
 * 订单业务接口
 */
public interface OrderService { // 公共接口
    void generate();
    void modify();
    void detail();

    String getName();
}
