package com.apple.prac3;

/**
 * 演示stack over flow，并配置JVM参数：-Xss(栈内存大小重新设置为256k）
 * 设置前 ->  17697
 * 设置后 -> 2080
 */
public class TestStackOverFlow {
    public static int count;

    public static void main(String[] args) {
        try {
            method1();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("count = " + count);
        }
    }

    static void method1(){
        count++;
        method1();
    }
}
