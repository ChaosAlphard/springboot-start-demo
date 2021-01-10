package com.ilirus.springbootdemo.handler.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilirus.springbootdemo.handler.annotation.WithResponseHandler;
import com.ilirus.springbootdemo.model.common.R;
import com.ilirus.springbootdemo.utils.LogUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(annotations = WithResponseHandler.class)
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return !returnType.getParameterType().isAssignableFrom(R.class)&&
                !returnType.hasMethodAnnotation(WithResponseHandler.Disable.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {

        if(returnType.getParameterType().isAssignableFrom(String.class)) {
            try {
                return new ObjectMapper().writeValueAsString(R.ofSuccess(body));
            } catch (JsonProcessingException e) {
                LogUtil.limitedStackTrace(e, "Json转换异常");
            }
        }

        return R.ofSuccess(body);
    }
}
