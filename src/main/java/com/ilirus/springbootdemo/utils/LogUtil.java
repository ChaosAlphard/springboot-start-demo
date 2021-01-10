package com.ilirus.springbootdemo.utils;

import com.ilirus.springbootdemo.asserts.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;

import java.util.Arrays;

/**
 * @author wan
 * @version 1.0.0
 * Date 2020/11/28 15:20
 */
@SuppressWarnings("unused")
public class LogUtil {
    private static final Logger log = LoggerFactory.getLogger(LogUtil.class);

    private static final int DEFAULT_STACK_LINE = 18;

    private static final String[] IGNORE_CLASS = {
            LogUtil.class.getName(),
            Assert.class.getName()
    };

    public static void debug(String s) {
        log.debug(getTracedLog(s));
    }

    public static void debug(String format, Object... args) {
        log.debug(getTracedLog(format), format(args));
    }

    public static void info(String s) {
        log.info(getTracedLog(s));
    }

    public static void info(String format, Object... args) {
        log.info(getTracedLog(format), format(args));
    }

    public static void warn(String s) {
        log.warn(getTracedLog(s));
    }

    public static void warn(String format, Object... args) {
        log.warn(getTracedLog(format), format(args));
    }

    public static void error(String s) {
        log.error(getTracedLog(s));
    }

    public static void error(String format, Object... args) {
        log.error(getTracedLog(format), format(args));
    }

    /**
     * 打印错误信息以及部分堆栈追踪
     * @param e 错误
     * @param limit 限制堆栈追踪的数量, 默认18条
     * @param message 额外的信息
     */
    public static void limitedStackTrace(Exception e, int limit, String message) {
        StackTraceElement[] traces = e.getStackTrace();
        int line = Math.min(traces.length, limit);

        StringBuilder builder = new StringBuilder(message)
                .append("\n")
                .append(e.getClass().getName())
                .append(": ")
                .append(e.getMessage());

        for (int i = 0; i < line; i++) {
            builder.append("\n\t").append(traces[i]);
        }

        log.error(builder.toString());
    }

    public static void limitedStackTrace(Exception e, int limit, String format, Object... args) {
        limitedStackTrace(e, limit, toLogStr(format, format(args)));
    }

    public static void limitedStackTrace(Exception e, String format, Object... args) {
        limitedStackTrace(e, DEFAULT_STACK_LINE, toLogStr(format, format(args)));
    }

    public static void limitedStackTrace(Exception e, String message) {
        limitedStackTrace(e, DEFAULT_STACK_LINE, message);
    }

    public static void limitedStackTrace(Exception e, int limit) {
        limitedStackTrace(e, limit, "详细信息 ↓");
    }

    public static void limitedStackTrace(Exception e) {
        limitedStackTrace(e, DEFAULT_STACK_LINE, "详细信息 ↓");
    }

    public static String toLogStr(String format, Object... args) {
        return MessageFormatter
                .arrayFormat(format, format(args)).getMessage();
    }

    private static Object[] format(Object... objects) {
        if(objects == null) {
            return new Object[]{null};
        }
        return objects;
    }

    private static String getStack() {
        StackTraceElement[] trace = new Exception().getStackTrace();
        for (StackTraceElement stack : trace) {
            if(Arrays.stream(IGNORE_CLASS).noneMatch(stack.getClassName()::equalsIgnoreCase)) {
                return stack.toString();
            }
        }
        return IGNORE_CLASS[0];
    }

    private static String getTracedLog(String str) {
        return getStack() + ": " + str;
    }
}
