package cn.spring.dao.impl;

import cn.spring.dao.StuDao;
import org.springframework.stereotype.Repository;

@Repository("stuDaoImplMySQL")
public class StuDaoImplMySQL implements StuDao {
    @Override
    public void delById() {
        System.out.println("MySQL,,,,,,");
    }
}
