package com.ilirus.springbootdemo.handler.advice;

import com.ilirus.springbootdemo.handler.annotation.WithExceptionHandler;
import com.ilirus.springbootdemo.model.common.R;
import com.ilirus.springbootdemo.utils.LogUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice(annotations = WithExceptionHandler.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R<Void> handler(Exception e, HttpServletRequest request) {
        LogUtil.limitedStackTrace(e, "未处理的异常, url: {}", request.getRequestURL());
        return R.ofFail();
    }
}
