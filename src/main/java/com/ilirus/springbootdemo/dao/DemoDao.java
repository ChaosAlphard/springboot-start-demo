package com.ilirus.springbootdemo.dao;

import com.ilirus.springbootdemo.model.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wan
 * @version 1.0.0
 * Date 2020/10/24 02:30
 */
public interface DemoDao extends JpaRepository<User, Long> {
}
