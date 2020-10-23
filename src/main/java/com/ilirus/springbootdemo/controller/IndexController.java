package com.ilirus.springbootdemo.controller;

import com.ilirus.springbootdemo.dao.DemoDao;
import com.ilirus.springbootdemo.model.Env;
import com.ilirus.springbootdemo.model.po.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wan
 * @version 1.0.0
 * Date 2020/10/23 01:48
 */
@Controller
@RequestMapping("/")
public class IndexController {
    private final Env env;
    private final DemoDao dao;

    public IndexController(Env env, DemoDao dao) {
        this.env = env;
        this.dao = dao;
    }

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @GetMapping
    public String index() {
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        return "index";
    }

    @GetMapping("/env")
    @ResponseBody
    public Env getEnvInfo() {
        return env;
    }

    @GetMapping("/db")
    @ResponseBody
    public List<User> getUser() {
        return dao.query();
    }
}
