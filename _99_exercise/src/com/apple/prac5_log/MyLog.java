package com.apple.prac5_log;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 自定义日志实现
 */
public class MyLog {
    /**
     * 单例模式
     */
    private static MyLog myLog = new MyLog();
    public static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue();

    private MyLog() {
    }

    public static MyLog me() {
        return myLog;
    }

    /**
     * 打印实现
     */
    public void info(String msg) {
        queue.offer(msg);
    }
}

