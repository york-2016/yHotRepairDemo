package com.york.rexiufu.utils;

import android.text.TextUtils;
import android.util.Log;

public class LogUtil {
    public static String LOG = " YorkTest";
    private static int LOG_LEVEL = 0;
    public enum LogLevel {
        VERBOSE, DEBUG, INFO, WARN, ERROR, NOLOG
    }

    private LogUtil() {
    }

    private static String getTag() {
        StackTraceElement caller = new Throwable().getStackTrace()[2];
        String tag = "《%s.%s》(Line：%d)"; // 占位符
        String callerClassName = caller.getClassName(); // 获取到类名
        callerClassName = callerClassName.substring(callerClassName.lastIndexOf(".") + 1);
        tag = String.format(tag, callerClassName, caller.getMethodName(), caller.getLineNumber()); // 替换
        tag = TextUtils.isEmpty(LOG) ? tag : LOG + "：" + tag;
        return tag;
    }

    /**
     * 日志的等级，默认为1，
     * 可以显示所有的日志等级
     * ①应用开发阶段，等级调为0可以保留所有等级的日志
     * ②在应用上线的时候，将日志等级调到2等级，那么只会保留w和e的日志信息
     * ③在应用上线的时候，将日志等级调到6等级，将会清楚所有日志信息，推荐使用6
     */

    public static void e( String msg) {
        if (LOG_LEVEL <= 1)
            Log.e(getTag() , msg);
    }

    public static void e(String msg, Throwable tr) {
        if (LOG_LEVEL <= 1)
            Log.e(getTag(), msg, tr);
    }

    public static void w( String msg) {
        if (LOG_LEVEL <= 2)
            Log.w(getTag(), msg);
    }

    public static void w( String msg, Throwable tr) {
        if (LOG_LEVEL <= 2)
            Log.w(getTag(), msg, tr);
    }

    public static void i( String msg) {
        if (LOG_LEVEL <= 3)
            Log.i(getTag(), msg);
    }

    public static void i(String msg, Throwable tr) {
        if (LOG_LEVEL <= 3)
            Log.i(getTag(), msg, tr);
    }

    public static void d( String msg) {
        if (LOG_LEVEL <= 4)
            Log.d(getTag() , msg);
    }

    public static void d(String msg, Throwable tr) {
        if (LOG_LEVEL <= 4)
            Log.d(getTag() , msg, tr);
    }

    public static void v(String msg) {
        if (LOG_LEVEL <= 5)
            Log.v(getTag(), msg);
    }

    public static void v( String msg, Throwable tr) {
        if (LOG_LEVEL <= 5)
            Log.v(getTag(), msg, tr);
    }

    public static void changeLogLevel(LogLevel logLevel) {
        switch (logLevel) {
            case VERBOSE:
                LOG_LEVEL = 5;
                break;
            case DEBUG:
                LOG_LEVEL = 4;
                break;
            case ERROR:
                LOG_LEVEL = 3;
                break;
            case INFO:
                LOG_LEVEL = 2;
                break;
            case WARN:
                LOG_LEVEL = 1;
                break;
            case NOLOG:
                LOG_LEVEL = 6;
                break;
            default:
                LOG_LEVEL = 0;
                break;
        }
    }

}
