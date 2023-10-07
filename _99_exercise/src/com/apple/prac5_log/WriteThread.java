package com.apple.prac5_log;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 到缓存队列中取消息，然后写入磁盘。涉及到IO操作，比较耗时。
 */
public class WriteThread implements Runnable{
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String msg = MyLog.queue.poll();
            if (msg != null && !msg.equals("")){
                // 追加到我的电脑上文稿中的mylog文件
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter("/Users/zhousong/Documents/mylog.doc", true); // 第二个参数表示追加模式
                    fileWriter.write(msg);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e) {
                            // 处理关闭文件时的异常
                        }
                    }
                }
            }

        }

    }
}
