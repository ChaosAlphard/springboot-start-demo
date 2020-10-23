package com.ilirus.springbootdemo;

import com.ilirus.springbootdemo.model.Env;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDemoApplicationTests {
    @Autowired
    private Env env;

    @Test
    void contextLoads() {
        System.out.println(env.getMap());
    }

}
