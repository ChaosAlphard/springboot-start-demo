package com.ilirus.springbootdemo.handler.annotation;

import java.lang.annotation.*;

/**
 * @author wan
 * @version 1.0.0
 * Date 2021/08/11 01:40
 */
@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserId {
}
