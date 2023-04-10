package com.apple.prac1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Thread2 implements Runnable{
    @Override
    public void run() {

    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("djj");
        FileInputStream stream = new FileInputStream("d");
    }
}
