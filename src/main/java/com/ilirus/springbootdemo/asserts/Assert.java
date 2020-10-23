package com.ilirus.springbootdemo.asserts;

import com.ilirus.springbootdemo.asserts.base.IBaseAssert;
import lombok.Getter;

/**
 * @author wan
 * @version 1.0.0
 * Date 2020/10/23 02:53
 */
@Getter
public enum Assert implements IBaseAssert {
    DATA_EXIST(500, "对象不存在"),
    SQL_EXECUTE(501, "SQL执行异常")
    ;

    private final int code;
    private final String message;

    Assert(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
