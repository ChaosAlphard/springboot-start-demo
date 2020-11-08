package com.ilirus.springbootdemo.model.param;

import com.ilirus.springbootdemo.annotation.validate.Time;
import com.ilirus.springbootdemo.handler.validate.IGet;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author wan
 * @version 1.0.0
 * @date 2020/11/08 21:00
 */
public class IndexParam {
    @NotNull(message = "id null")
    private Integer id;
    @NotBlank(message = "name null")
    private String name;
    @Time(allowNull = true, groups = IGet.class)
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
