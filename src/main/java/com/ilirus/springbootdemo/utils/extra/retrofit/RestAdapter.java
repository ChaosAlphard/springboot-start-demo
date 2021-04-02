package com.ilirus.springbootdemo.utils.extra.retrofit;

import com.ilirus.springbootdemo.utils.LogUtil;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author wan
 * @version 1.0.0
 * Date 2021/04/03 02:49
 */
public class RestAdapter<T> implements CallAdapter<T, T> {
    private final Type responseType;

    public RestAdapter(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public T adapt(Call<T> call) {
        try {
            Response<T> execute = call.execute();
            if (execute.isSuccessful()) {
                return execute.body();
            }
            if (execute.errorBody() != null) {
                LogUtil.error("网络请求失败, {}", execute.errorBody().string());
            }
        } catch (IOException e) {
            LogUtil.limitedStackTrace(e, "网络异常");
        }
        return null;
    }
}
