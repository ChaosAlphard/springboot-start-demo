package com.ilirus.springbootdemo.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ilirus.springbootdemo.model.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wan
 * @version 1.0.0
 * Date 2021/10/08 00:04
 */
@SpringBootTest
class UserDaoTest {
    @Autowired
    private UserDao dao;

    @Test
    void query() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.le(User::getAge, 20);
        wrapper.last("limit 1");

        System.out.println(dao.selectOne(wrapper));
    }
}
