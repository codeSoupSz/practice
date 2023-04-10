package com.apple.prac1;
/*
多线程操作
需求：计算1累加到10000的和。交给10个线程来分担压力。
*/
public class ThreadPractice {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            SumThread thread = new SumThread(i*1000+1);
            thread.start();
            thread.join();
        }
        System.out.println("SumThread.sumResult = " + SumThread.sumResult);
        System.out.println("-----以下为验证结果----");
        int sum = 0;
        for (int i = 1; i <= 10000; i++) {
            sum = sum + i;
        }
        System.out.println("sum = " + sum);
    }
}

//思路一：创建一个线程类，放一个共享变量sumResult,和一个构造变量startNum.
class SumThread extends Thread{
    public static int sumResult;
    private int startNum;

    @Override
    public void run() {
        int sum = 0;
        for (int i = startNum; i < startNum+1000; i++) {
            sum += i;
        }
        this.sumResult += sum;
    }

    public SumThread(int startNum){
        this.startNum = startNum;
    }

}
