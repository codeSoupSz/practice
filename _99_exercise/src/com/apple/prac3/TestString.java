package com.apple.prac3;

public class TestString {
    public static void main(String[] args) {
        String a = new String("1")+new String("2");
        String b = "12";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a == b);
    }
}
