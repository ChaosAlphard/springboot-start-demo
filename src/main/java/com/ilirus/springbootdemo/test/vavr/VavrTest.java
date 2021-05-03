package com.ilirus.springbootdemo.test.vavr;

import io.vavr.Function4;
import io.vavr.control.Option;
import io.vavr.control.Try;

import java.util.HashMap;

import static io.vavr.API.*;

/**
 * @author wan
 * @version 1.0.0
 * Date 2021/05/03 03:14
 */
public class VavrTest {
    private Function4<Integer, Integer, Integer ,Integer, Integer> sum = (a,b,c,d) -> a+b+c+d;
    private HashMap<String, Integer[]> map = new HashMap<>() {{
        put("some", new Integer[]{1, 2, 3});
        put("empty", new Integer[0]);
        put("none", null);
    }};

    public void Option() {
        Integer some = Option.of(map)
                .map(it -> it.get("some"))
                .filter(arr -> arr != null && arr.length > 0)
                .map(arr -> arr[0])
                .getOrElse(-1);
        System.out.println(some);

        Integer empty = Option.of(map)
                .map(it -> it.get("empty"))
                .filter(arr -> arr != null && arr.length > 0)
                .map(arr -> arr[0])
                .getOrElse(-1);
        System.out.println(empty);

        Integer none = Option.of(map)
                .map(it -> it.get("none"))
                .filter(arr -> arr != null && arr.length > 0)
                .map(arr -> arr[0])
                .getOrElse(-1);
        System.out.println(none);
    }

    public void Try(Exception e) {
        String str = Try.of(() -> {
            if (true) {
                throw e;
            }
            return "";
        })
                .onSuccess(System.out::println)
                .onFailure(it -> System.out.println("fail: " + it.getMessage()))
                .recoverWith(NullPointerException.class, Try.failure(new IndexOutOfBoundsException("recoverToIndexOutOfBoundsException")))
                .recoverWith(IllegalArgumentException.class, Try.success("catchIllegalArgumentException"))
                .recoverWith(IndexOutOfBoundsException.class, Try.success("catchIndexOutOfBoundsException"))
                .getOrElse("default");
        System.out.println(str);
    }

    public void match(int num) {
        // require import static io.vavr.API.*;
        String s = Match(num).of(
                Case($(v -> v < 50), "50"),
                Case($(v -> v < 100), "100"),
                Case($(), "default")
        );
        System.out.println(s);
    }

    public void curried() {
        var curried = sum.apply(0, 0).curried();
        System.out.println(curried.apply(1).apply(2));
        System.out.println(curried.apply(10).apply(20));

        var curried2 = sum.curried().apply(100).apply(100);
        System.out.println(curried2.apply(1).apply(2));
        System.out.println(curried2.apply(10).apply(20));
    }

    public static void main(String[] args) {
        VavrTest test = new VavrTest();

        test.Option();
        // test.curried();
        // test.match(101);
        // test.match(80);
        // test.match(10);
        // test.match(0);
        // test.Try(new Exception("Exception"));
        // test.Try(new NullPointerException("NullPointerException"));
        // test.Try(new RuntimeException("RuntimeException"));
        // test.Try(new IllegalArgumentException("IllegalArgumentException"));
    }
}
