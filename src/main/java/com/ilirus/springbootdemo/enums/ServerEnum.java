package com.ilirus.springbootdemo.enums;

import lombok.Getter;

/**
 * @author wan
 * @version 1.0.0
 * Date 2020/10/23 02:43
 */
@Getter
public enum  ServerEnum {
    SUCCESS(200, "Success"),
    FAIL(500, "Fail")
    ;

    private final int code;
    private final String message;

    ServerEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
