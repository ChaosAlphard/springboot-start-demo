package com.ilirus.springbootdemo.handler;

import com.ilirus.springbootdemo.annotation.WithExceptionHandler;
import com.ilirus.springbootdemo.model.common.R;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wan
 * @version 1.0.0
 * @date 2020/11/08 21:16
 */
@RestControllerAdvice(annotations = {WithExceptionHandler.class})
@ResponseStatus(HttpStatus.OK)
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<List<Map<String, Object>>> argNotValidErr(MethodArgumentNotValidException e) {
        return R.ofFail(getValidError(e.getBindingResult()));
    }

    @ExceptionHandler(BindException.class)
    public R<List<Map<String, Object>>> argNotValidErr(BindException e) {
        return R.ofFail(getValidError(e.getBindingResult()));
    }

    @ExceptionHandler(Exception.class)
    public R<Object> error(Exception e) {
        return R.ofFail(e.getMessage());
    }

    private List<Map<String, Object>> getValidError(BindingResult result) {
        if(result == null) {
            return new ArrayList<>(0);
        }

        List<Map<String, Object>> lis = new ArrayList<>();
        for(FieldError error : result.getFieldErrors()) {
            lis.add(new HashMap<>(){{
                put("field", error.getField());
                put("message", error.getDefaultMessage());
                put("rejectValue", error.getRejectedValue());
            }});
        }

        return lis;
    }
}
