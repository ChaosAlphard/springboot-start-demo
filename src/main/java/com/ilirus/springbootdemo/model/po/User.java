package com.ilirus.springbootdemo.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Short age;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
}
