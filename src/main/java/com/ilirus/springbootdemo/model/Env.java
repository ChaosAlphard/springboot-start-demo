package com.ilirus.springbootdemo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author wan
 * @version 1.0.0
 * Date 2020/10/23 01:51
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "env")
public class Env {
    private String name;
    private String des;
    private ListContainer list;
    private List<User> objectList1;
    private List<User> objectList2;
    private List<String> listCopy;
    private Map<String, String> map;

    @Getter
    @Setter
    public static class ListContainer{
        private List<String> list1;
        private List<String> list2;
    }

    @Getter
    @Setter
    public static class User{
        private String id;
        private String name;
    }
}
