package com.ilirus.springbootdemo.model.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author wan
 * @version 1.0.0
 * Date 2020/10/24 02:27
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    private Long id;
    @Column(name = "name", length = 32, nullable = true, unique = false)
    private String name;
    @Column(name = "age")
    private Short age;
    @Column
    private LocalDateTime updateTime;
    @Column
    private LocalDateTime createTime;
}
