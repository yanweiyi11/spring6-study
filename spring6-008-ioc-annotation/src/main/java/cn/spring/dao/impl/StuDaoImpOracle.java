package cn.spring.dao.impl;

import cn.spring.dao.StuDao;
import org.springframework.stereotype.Repository;

@Repository("stuDaoImpOracle")
public class StuDaoImpOracle implements StuDao {
    @Override
    public void delById() {
        System.out.println("Oracle,,,,,,");
    }
}
