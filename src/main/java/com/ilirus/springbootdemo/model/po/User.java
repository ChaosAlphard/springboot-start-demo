package com.ilirus.springbootdemo.model.po;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

/**
 * @author wan
 * @version 1.0.0
 * Date 2020/10/24 02:02
 */
@Data
@Alias("User")
public class User {
    private Long id;
    private String name;
    private Short age;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
}
