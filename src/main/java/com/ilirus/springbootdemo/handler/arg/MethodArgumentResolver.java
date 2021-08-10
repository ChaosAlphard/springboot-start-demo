package com.ilirus.springbootdemo.handler.arg;

import com.ilirus.springbootdemo.exceptions.ApiException;
import com.ilirus.springbootdemo.handler.annotation.UserId;
import com.ilirus.springbootdemo.utils.LogUtil;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author wan
 * @version 1.0.0
 * Date 2021/08/10 15:45
 */
public class MethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(UserId.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Class<?> parameterType = parameter.getParameterType();
        if (!(parameterType.isAssignableFrom(Integer.class)||
                parameterType.isAssignableFrom(int.class))) {
            LogUtil.getLogger().warn("需要为Integer或Int类型");
            throw new ApiException(1,"需要为Integer或Int类型");
        }
        return 1;
    }
}
