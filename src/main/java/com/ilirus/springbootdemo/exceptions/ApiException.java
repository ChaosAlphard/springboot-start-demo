package com.ilirus.springbootdemo.exceptions;

import com.ilirus.springbootdemo.enums.ServerEnum;
import com.ilirus.springbootdemo.exceptions.base.BaseException;

/**
 * @author wan
 * @version 1.0.0
 * Date 2020/10/23 03:13
 */
public class ApiException extends BaseException {
    public ApiException(int code, String message, String detail, Object data) {
        super(code, message, detail, data);
    }

    public ApiException(int code, String message, String detail) {
        super(code, message, detail);
    }

    public ApiException(int code, String message) {
        super(code, message);
    }

    public ApiException(ServerEnum serverEnum, String detail, Object data) {
        super(serverEnum, detail, data);
    }

    public ApiException(ServerEnum serverEnum, String detail) {
        super(serverEnum, detail);
    }

    public ApiException(ServerEnum serverEnum) {
        super(serverEnum);
    }
}
