package com.work._03_linkedList;

import java.util.LinkedList;

/**
 * 单向链表
 * 需求：利用单向链表完成 水浒英雄排行榜的增删改查。增加要求两种方式：一种尾插；一种按照编号顺序
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(5, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(5, "林冲5", "豹子头5");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        System.out.println("---原始链表数据");
        singleLinkedList.list();
        singleLinkedList.modify(hero5);
        System.out.println("---验证修改");
        singleLinkedList.list();
        singleLinkedList.remove(1);
        System.out.println("---验证删除");
        singleLinkedList.list();
        LinkedList<Object> objects = new LinkedList<>();

    }
}

/**
 * 定义一个单向链表，管理英雄榜
 */
class SingleLinkedList {
    //初始化一个头节点。头节点不动，定下开始寻找的内存地址。
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 增加节点，尾插法
     */
    public void add(HeroNode node) {
        /**
         * temp作为临时节点的设计：temp可以代表链表中的任何一个节点，动态变化。
         * 一开始，temp代表头节点。可后面，又代表了其他节点。
         */
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 按照编号顺序添加
     * @param node
     */
    public void addByOrder(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.getNo() == node.getNo()) {
                System.out.println("编号已存在" + node.getNo());
                break;
            }
            if (temp.next == null) {
                temp.next = node;
                break;
            }
            if (node.getNo() < temp.next.getNo()) {
                node.next = temp.next;// 这里一开始写成了 temp.next.next
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 删除节点(根据英雄编号）
     * @param no
     */
    public void remove(int no) {
        HeroNode temp = head;
        if (temp.next == null)
            System.out.println("这是个空链表");
        while (true){
            // ***注意以下两个if的顺序，开始放反了引起了NPE
            if (temp.next == null){
                System.out.println("要删除的节点不存在");
                break;
            }
            if (temp.next.getNo() == no){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }

    }

    /**
     * 修改节点(根据英雄编号）
     * @param node
     */
    public void modify(HeroNode node) {
        HeroNode temp = head;
        if (temp.next == null){
            System.out.println("这是个空链表！");
        }
        while (true){
            if (temp.next == null){ //***这里一开始没有写的只是temp，诱发了NPE¶
                System.out.println("要修改的节点不存在");
                break;
            }
            if (temp.next.getNo() == node.getNo()){
                temp.next = node;
                break;
            }
            temp = temp.next;
        }

    }

    /**
     * 显示链表所有节点
     */
    public void list() {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
    }

}

/**
 * 定义 节点，表示一个具体的英雄
 */
class HeroNode {
    private int no;
    private String name;
    private String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }
}
