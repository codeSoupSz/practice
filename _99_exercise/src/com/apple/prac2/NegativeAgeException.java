package com.apple.prac2;

public class NegativeAgeException extends Exception{
    private String message;
    public NegativeAgeException(String s) {
        message = s;
    }

    @Override
    public String toString() {
        return message;
    }
}
class Student{
    private int age;
    private String name;

    public Student(int age, String name) throws NegativeAgeException {
        if (age < 0){
            throw new NegativeAgeException("年龄小于0: " + age);
        }
        this.age = age;
        this.name = name;
    }
}
class MyExceptionDemo{
    public static void main(String[] args) {
        try {
            Student student = new Student(-111, "小明");
        } catch (NegativeAgeException e) {
            e.printStackTrace();
        }finally {
            System.out.println("程序结束");
        }
    }
}
