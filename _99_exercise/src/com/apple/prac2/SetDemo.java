package com.apple.prac2;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> numsSet = new HashSet<>();
        numsSet.add(1);
        numsSet.add(2);
        numsSet.add(1);
        System.out.println("numsSet = " + numsSet);

    }
    @Test
    public void test01(){
        Object obj1 = new Object();
        System.out.println("obj1 = " + obj1);
        System.out.println("obj1.hashCode() = " + obj1.hashCode());
        Object obj2 = new Object();
        System.out.println("obj2.hashCode() = " + obj2.hashCode());
    }
    @Test
    public void test02(){
        int[] arr = {1,2,3};
        try {
            System.out.println("arr[3] = " + arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

}
