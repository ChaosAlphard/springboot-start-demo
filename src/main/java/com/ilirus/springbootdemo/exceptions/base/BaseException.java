package com.ilirus.springbootdemo.exceptions.base;

import com.ilirus.springbootdemo.enums.ServerEnum;
import lombok.Getter;

/**
 * @author wan
 * @version 1.0.0
 * Date 2020/10/23 02:39
 */
@Getter
public class BaseException extends Exception {
    private final int code;
    private final String detail;
    private final Object data;

    public BaseException(int code, String message, String detail, Object data) {
        super(message);
        this.code = code;
        this.detail = detail;
        this.data = data;
    }

    public BaseException(int code, String message, String detail) {
        this(code, message, detail, null);
    }

    public BaseException(int code, String message) {
        this(code, message, null, null);
    }

    public BaseException(ServerEnum serverEnum, String detail, Object data) {
        super(serverEnum.getMessage());
        this.code = serverEnum.getCode();
        this.detail = detail;
        this.data = data;
    }

    public BaseException(ServerEnum serverEnum, String detail) {
        this(serverEnum, detail, null);
    }

    public BaseException(ServerEnum serverEnum) {
        this(serverEnum, null, null);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{code=" + code + ", message='" + super.getMessage() + "', detail='" + detail + "', data=" + data + '}';
    }
}
