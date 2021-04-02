package com.ilirus.springbootdemo.utils.extra.retrofit;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @author wan
 * @version 1.0.0
 * Date 2021/04/03 03:07
 */
public class RestAdapterFactory extends CallAdapter.Factory {
    @Override
    public CallAdapter<?, ?> get(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new RestAdapter<>(getRawType(type));
    }

    public static RestAdapterFactory newInstance() {
        return new RestAdapterFactory();
    }
}
