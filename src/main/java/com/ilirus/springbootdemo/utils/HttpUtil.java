package com.ilirus.springbootdemo.utils;

import com.ilirus.springbootdemo.utils.extra.retrofit.JacksonConverterFactory;
import com.ilirus.springbootdemo.utils.extra.retrofit.RestAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.time.Duration;

/**
 * @author wan
 * @version 1.0.0
 * Date 2021/04/03 02:21
 */
public class HttpUtil {

    public static <T> T newInstance(Class<T> service, String host, Converter.Factory converter, CallAdapter.Factory adapter) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(Duration.ofSeconds(3))
                .readTimeout(Duration.ofSeconds(10))
                .writeTimeout(Duration.ofSeconds(3))
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    // 这里只能获取到自己添加的header信息
                    LogUtil.debug("Header: {}", request.headers());
                    Request newRequest = request.newBuilder()
                            .addHeader("token", "token")
                            .build();

                    // 使用新增Header后的request替换原有的request
                    return chain.proceed(newRequest);
                })
                .addNetworkInterceptor(chain -> {
                    Request request = chain.request();
                    // 这里可以获取到所有的header信息
                    LogUtil.debug("Header: {}", request.headers());

                    return chain.proceed(request);
                }).build();
        Retrofit.Builder builder = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(converter)
                .addCallAdapterFactory(adapter);
        if (host != null) {
            builder.baseUrl(host);
        }
        return builder.build().create(service);
    }

    public static <T> T newInstance(Class<T> service, String host) {
        return newInstance(service, host, JacksonConverterFactory.newInstance(), RestAdapterFactory.newInstance());
    }

    public static <T> T newInstance(Class<T> service) {
        return newInstance(service, null, JacksonConverterFactory.newInstance(), RestAdapterFactory.newInstance());
    }
}
