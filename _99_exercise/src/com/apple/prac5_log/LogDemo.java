package com.apple.prac5_log;

import java.util.Date;

public class LogDemo {
    public static void main(String[] args) {
        MyLog myLog = MyLog.me();
        myLog.info("\n自定义日志打印，当前时间为：" + new Date() + "\n");
        int result = add(100, 200);
        myLog.info("当前计算结果为：" + result + "\n");
        new WriteThread().run();
    }

    private static int add(int a, int b) {
        MyLog.me().info("计算以下两个数字的和：" + a + "和" + b + "\n");
        return a + b;
    }
}
