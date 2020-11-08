package com.ilirus.springbootdemo.annotation.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author wan
 * @version 1.0.0
 * @date 2020/11/08 21:52
 */
public class TimeValidate implements ConstraintValidator<Time, String> {
    private boolean allowNull;
    private Pattern regexp;

    @Override
    public void initialize(Time annotation) {
        allowNull = annotation.allowNull();
        regexp = Pattern.compile(annotation.regexp());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(allowNull&&value == null) {
            return true;
        }
        return regexp.matcher(value).matches();
    }
}
