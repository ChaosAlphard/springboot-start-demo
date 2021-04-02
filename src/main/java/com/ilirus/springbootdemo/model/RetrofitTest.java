package com.ilirus.springbootdemo.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * @author wan
 * @version 1.0.0
 * Date 2021/04/03 03:42
 */
@Data
@JsonPropertyOrder({"age", "name", "remark"})
public class RetrofitTest {
    private String name;
    private Integer age;
    private String remark;
}
