package cn.spring.service;

import cn.spring.dao.StuDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StuService {

    // @Resource(name = "stuDaoImplMySQL")
    @Resource
    private StuDao stuDaoImpOracle;

    // @Resource(name = "stuDaoImplMySQL")
    // public void setStuDao(StuDao stuDao) {
    //     this.stuDao = stuDao;
    // }

    // 不能出现在构造方法上
    // @Resource(name = "stuDaoImplMySQL")
    // public StuService(StuDao stuDao) {
    //     this.stuDao = stuDao;
    // }

    public void delStu() {
        stuDaoImpOracle.delById();
    }
}
