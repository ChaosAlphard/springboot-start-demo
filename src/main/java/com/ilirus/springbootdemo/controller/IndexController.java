package com.ilirus.springbootdemo.controller;

import com.ilirus.springbootdemo.handler.annotation.ApiController;
import com.ilirus.springbootdemo.handler.annotation.WithResponseHandler;
import com.ilirus.springbootdemo.model.Env;
import com.ilirus.springbootdemo.model.RetrofitTest;
import com.ilirus.springbootdemo.model.common.R;
import com.ilirus.springbootdemo.utils.HttpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author wan
 * @version 1.0.0
 * Date 2020/10/23 01:48
 */
@ApiController("/")
public class IndexController {
    private final Env env;
    private final RetrofitTestService service = HttpUtil.newInstance(RetrofitTestService.class, "http://127.0.0.1:80");

    public IndexController(Env env) {
        this.env = env;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/env")
    @ResponseBody
    public Env getEnvInfo() {
        return env;
    }

    @GetMapping("/retrofit")
    @ResponseBody
    public R<List<RetrofitTest>> toRetrofit() {
        RetrofitTest tr = new RetrofitTest();
        tr.setName("Ilirus");
        tr.setAge(24);

        List<RetrofitTest> test = service.doTest(tr);

        return R.ofSuccess(test);
    }

    @WithResponseHandler.Disable
    @RequestMapping("/retrofit/test")
    @ResponseBody
    public List<RetrofitTest> toRetrofit(@RequestBody RetrofitTest param) {
        ArrayList<RetrofitTest> tests = new ArrayList<>();
        int len = new Random().nextInt(10);
        for (int i = 0; i < len; i++) {
            tests.add(param);
        }
        return tests;
    }

    private interface RetrofitTestService {
        @POST("/retrofit/test")
        List<RetrofitTest> doTest(@Body RetrofitTest test);
    }
}
