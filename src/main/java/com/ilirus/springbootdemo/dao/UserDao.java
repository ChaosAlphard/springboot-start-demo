package com.ilirus.springbootdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ilirus.springbootdemo.model.po.User;
import org.springframework.stereotype.Repository;

/**
 * @author wan
 * @version 1.0.0
 * Date 2021/10/07 23:49
 */
@Repository
public interface UserDao extends BaseMapper<User> {
}
