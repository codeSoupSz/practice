package com.work._02_queue;

import java.util.Scanner;

/**
 * 普通队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试普通队列
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        ArrayQueue queue = new ArrayQueue(3);
        while (flag) {
            System.out.println("-----操作指南----");
            System.out.println("a(add):往队列添加元素");
            System.out.println("g(get):从队列取出元素");
            System.out.println("h(head):队列的第一个元素");
            System.out.println("s(show):展示队列的元素");
            System.out.println("e(exit):退出");
            System.out.println("----------");
            String next = scanner.next();
            switch (next) {
                case "a":
                    System.out.print("请输入要添加的元素:");
                    try {
                        int i = scanner.nextInt();
                        queue.addToQueue(i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "g":
                    try {
                        int num = queue.getFromQueue();
                        System.out.println("取出的元素为" + num);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "h":
                    int head = 0;
                    try {
                        head = queue.headOfQueue();
                        System.out.println("队列的第一个元素为" + head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "s":
                    try {
                        queue.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                    break;
                case "e":
                    scanner.close();
                    flag = false;
                    System.out.println("操作结束！");
                    break;
                default:
                    System.out.println("无效输入！");
            }
        }
    }
}

class ArrayQueue {
    //需要定义的几个属性 1-队列的最大容量maxSize 2-队列的头部head 3-队列的尾部rear 4-数组int[] arr,模拟队列
    private int maxSize;
    private int head;
    private int rear;
    private int[] arr;

    //设计一个构造器，传入队列的最大容量即可
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        head = -1;//设计头部位于第一个元素的前一个位置
        rear = -1;//设计尾部位于最后一个元素的位置
        arr = new int[maxSize];
    }

    //需要定义的几个方法 1-添加元素addToQueue() 2-取出元素getFromQueue()
    // 3-判断队列是否满了isFull() 4-判断队列是否为空isEmpty() 5-显示队列头部数据headOfQueue() 6-展示所有数据show()
    public void addToQueue(int n) {
        //首先要判断队列是否满了，如果满了则无法添加。抛出一个运行异常。
        if (isFull()) {
            throw new RuntimeException("队列已满，无法添加元素！");
        }
        arr[++rear] = n;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public int getFromQueue() {
        //首先要判断队列是否是空的
        if (isEmpty()) {
            throw new RuntimeException("队列是空的，无法取出数据");
        }
        return arr[++head];
    }

    public boolean isEmpty() {
        return head == rear;
    }

    public int headOfQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取头部数据！");
        }
        return arr[head + 1];
    }

    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法展示！");
        }
        for (int i = head + 1; i <= rear; i++) {
            System.out.print("\t" + arr[i]);
        }
    }
}
