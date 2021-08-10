package com.ilirus.springbootdemo.config;

import com.ilirus.springbootdemo.handler.arg.MethodArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author wan
 * @version 1.0.0
 * Date 2021/08/11 01:42
 */
@Configuration
public class ArgsHandlerConfig implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new MethodArgumentResolver());
    }
}
