package com.ilirus.springbootdemo.utils.extra.retrofit;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.ilirus.springbootdemo.utils.Jackson;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.io.Reader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @author wan
 * @version 1.0.0
 * Date 2021/05/03 04:50
 */
public class JacksonConverterFactory extends Converter.Factory {
    private final ObjectMapper mapper;
    private final MediaType mediaType;

    private JacksonConverterFactory(ObjectMapper mapper) {
        this.mapper = mapper;
        this.mediaType = MediaType.get("application/json; charset=UTF-8");
    }

    public static JacksonConverterFactory newInstance() {
        return new JacksonConverterFactory(Jackson.newInstance()
                .setDefaultPropertyInclusion(JsonInclude.Include.ALWAYS));
    }

    public static JacksonConverterFactory newInstance(ObjectMapper mapper) {
        return new JacksonConverterFactory(mapper);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type == String.class) {
            return ResponseBody::string;
        }

        JavaType javaType = mapper.getTypeFactory().constructType(type);
        ObjectReader reader = mapper.readerFor(javaType);
        return body -> {
            try (Reader charStream = body.charStream()) {
                return reader.readValue(charStream);
            }
        };
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return body -> RequestBody.create(mediaType, mapper.writeValueAsBytes(body));
    }

    @Override
    public Converter<?, String> stringConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return super.stringConverter(type, annotations, retrofit);
    }
}
