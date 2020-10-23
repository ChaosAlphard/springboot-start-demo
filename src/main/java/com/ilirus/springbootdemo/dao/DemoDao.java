package com.ilirus.springbootdemo.dao;

import com.ilirus.springbootdemo.model.po.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wan
 * @version 1.0.0
 * Date 2020/10/24 01:42
 */
@Repository
public interface DemoDao {
    List<User> query();
}
