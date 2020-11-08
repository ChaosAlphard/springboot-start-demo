package com.ilirus.springbootdemo.annotation;

import java.lang.annotation.*;

/**
 * @author wan
 * @version 1.0.0
 * @date 2020/11/08 21:37
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface WithExceptionHandler {
}
