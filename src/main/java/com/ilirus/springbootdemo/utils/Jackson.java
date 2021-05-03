package com.ilirus.springbootdemo.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.ilirus.springbootdemo.utils.extra.jackson.LocalDateSerializer;
import com.ilirus.springbootdemo.utils.extra.jackson.LocalDateTimeSerializer;
import com.ilirus.springbootdemo.utils.extra.vavr.Vavr;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author wan
 * @version 1.0.0
 * Date 2021/04/03 02:26
 */
public class Jackson {
    private static final ObjectMapper mapper = new ObjectMapper()
            // 设置遇到未定义字段时不抛出异常
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            // 设置仅序列化非空值
            .setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL)
            // 设置时间日期格式化处理器
            .registerModule(new SimpleModule()
                    .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer())
                    .addSerializer(LocalDate.class, new LocalDateSerializer())
            )
            .registerModule(Vavr.defaultInstance());

    public static ObjectMapper newInstance() {
        return mapper.copy();
    }

    public static <T> String toJsonString(T t) throws JsonProcessingException {
        return mapper.writeValueAsString(t);
    }

    public static <T> T toJavaObject(String jsonString, Class<T> tClass) throws JsonProcessingException {
        return mapper.readValue(jsonString, tClass);
    }

    public static <T> T toJavaObject(String jsonString, TypeReference<T> reference) throws JsonProcessingException {
        return mapper.readValue(jsonString, reference);
    }
}
