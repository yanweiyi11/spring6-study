package com.spring.bank.service.impl;

import com.spring.bank.dao.AccountDao;
import com.spring.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service("i2")
public class IsolationService2 {

    @Resource
    private AccountDao accountDao;

    // 2号
    // 负责插入
    // @Transactional(timeout = 10, readOnly = true) //设置事务超时时间为10秒
    // 设置readOnly = true，表示改方法不能执行增上改操作，只能进行查询操作
    // 这样做的好处是，可以告诉spring我们的这个方法是一个只读的方法，让spring启动他的优化策略，提高我们的select查询效率
    // @Transactional(rollbackFor = RuntimeException.class) // 只要发送RuntimeException或者这个异常的子类异常，都回滚
    @Transactional(noRollbackFor = NullPointerException.class) // 当异常是空指针异常的时候不回滚
    public void save(Account account) throws IOException {
        // 睡眠一会
        // try {
        //     Thread.sleep(1000 * 15);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        accountDao.insert(account); // 事务超时时间是怎么算的呢？
        // 模拟异常
        // if (1 == 1) throw new IOException();
        if (1 == 1) throw new RuntimeException();
        // if (1 == 1) throw new NullPointerException();

        // 就是在当前最后一条DML语句执行完成之前的时间，都算在事务超时时间。
        // 如果在最后一条DML语句执行完成后，还有很多的业务代码，这些都不算超时时间
        // 如果想从头到尾都算入超时时间，应该怎么做呢？
        // 可以在代码的最后一行添加一条无关紧要的DML语句
    }
}
