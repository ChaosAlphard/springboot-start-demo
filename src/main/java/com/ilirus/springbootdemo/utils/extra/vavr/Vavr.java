package com.ilirus.springbootdemo.utils.extra.vavr;

import io.vavr.jackson.datatype.VavrModule;

/**
 * @author wan
 * @version 1.0.0
 * Date 2021/05/03 03:17
 */
public class Vavr {
    private static final VavrModule VAVR = new VavrModule();

    public static VavrModule defaultInstance() {
        return VAVR;
    }
}
