package com.ilirus.springbootdemo.exceptions.base;

import com.ilirus.springbootdemo.asserts.base.IBaseAssert;
import lombok.Getter;

/**
 * @author wan
 * @version 1.0.0
 * Date 2020/10/23 02:38
 */
@Getter
public class BaseRuntimeException extends RuntimeException {
    private final int code;
    private final String detail;
    private final Object data;

    public BaseRuntimeException(int code, String message, String detail, Object data) {
        super(message);
        this.code = code;
        this.detail = detail;
        this.data = data;
    }

    public BaseRuntimeException(int code, String message, String detail) {
        this(code, message, detail, null);
    }

    public BaseRuntimeException(int code, String message) {
        this(code, message, null, null);
    }

    public BaseRuntimeException(IBaseAssert baseAssert, String detail, Object data) {
        super(baseAssert.getMessage());
        this.code = baseAssert.getCode();
        this.detail = detail;
        this.data = data;
    }

    public BaseRuntimeException(IBaseAssert baseAssert, String detail) {
        this(baseAssert, detail, null);
    }

    public BaseRuntimeException(IBaseAssert baseAssert) {
        this(baseAssert, null, null);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{code=" + code + ", message='" + super.getMessage() + "', detail='" + detail + "', data=" + data + '}';
    }
}
