package com.ilirus.springbootdemo.annotation.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author wan
 * @version 1.0.0
 * @date 2020/11/08 21:01
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Repeatable(Time.List.class)
@Constraint(validatedBy = {TimeValidate.class})
public @interface Time {
    boolean allowNull() default false;

    String regexp() default "^(([0-1][0-9])|(2[0-3])):[0-5][0-9]:[0-5][0-9]$";

    String message() default "时间格式错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    public @interface List {
        Time[] value();
    }
}
