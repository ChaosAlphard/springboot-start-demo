package com.ilirus.springbootdemo.model.common;

import com.ilirus.springbootdemo.asserts.base.IBaseAssert;
import com.ilirus.springbootdemo.enums.ServerEnum;
import lombok.Getter;

/**
 * @author wan
 * @version 1.0.0
 * Date 2020/10/23 03:04
 */
@Getter
public class R<T> {
    private final boolean success;
    private final int code;
    private final String message;
    private final T data;

    public static <T> R<T> ofSuccess() {
        return new R<>(true, ServerEnum.SUCCESS, null);
    }

    public static <T> R<T> ofSuccess(T data) {
        return new R<>(true, ServerEnum.SUCCESS, data);
    }

    private R(boolean success, int code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private R(boolean success, ServerEnum serverEnum, T data) {
        this.success = success;
        this.code = serverEnum.getCode();
        this.message = serverEnum.getMessage();
        this.data = data;
    }

    private R(boolean success, IBaseAssert baseAssert, T data) {
        this.success = success;
        this.code = baseAssert.getCode();
        this.message = baseAssert.getMessage();
        this.data = data;
    }
}
