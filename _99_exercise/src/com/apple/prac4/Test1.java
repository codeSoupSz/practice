package com.apple.prac4;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(31);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(30);
                break;
            case 2:
                if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
                    System.out.println(29);
                }else{
                    System.out.println(28);
                }
                break;
            default:
                break;

        }

    }
}

class Test2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
//        boolean flag = false;
//        for (int i = 2; i < num; i++) {
//            if (num % i == 0){
//                flag = false;
//                break;
//            }
//            flag = true;
//        }
//        if (flag){
//            System.out.println(num + "是质数");
//        }else{
//            System.out.println(num + "不是质数");
//        }
        boolean prime = Test2.isPrime(num);
        if (prime){
            System.out.println(num + "是质数");
        }else {
            System.out.println(num + "不是质数");
        }
    }

    public static boolean isPrime(int num){
        for (int i = 2; i < num; i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}

