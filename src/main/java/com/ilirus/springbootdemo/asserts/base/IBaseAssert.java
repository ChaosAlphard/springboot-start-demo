package com.ilirus.springbootdemo.asserts.base;

import com.ilirus.springbootdemo.exceptions.base.BaseRuntimeException;

/**
 * @author wan
 * @version 1.0.0
 * Date 2020/10/23 02:56
 */
public interface IBaseAssert extends IBaseEnumMethod, IBaseAssertThrow {
    default void notNull(Object o, String detail) {
        if(o == null) {
            throw new BaseRuntimeException(this, detail);
        }
    }

    default void sqlSuccess(int line, String detail) {
        if(line < 1) {
            throw new BaseRuntimeException(this, detail);
        }
    }
}
