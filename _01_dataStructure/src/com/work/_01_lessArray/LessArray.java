package com.work._01_lessArray;

public class LessArray {
    public static void main(String[] args) {
        //用二维数组模拟五子棋盘-->简化成稀疏数组-->恢复成二维数组
        //0-无子 1-黑子 2-白子
        System.out.println("--------二维数组模拟棋盘-------");
        int[][] chessArray1 = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        chessArray1[5][3] = 1;
        for (int[] arr : chessArray1) {
            for (int i : arr) {
                System.out.print("\t"+i);
            }
            System.out.println();
        }
        System.out.println("--------稀疏数组简化二维数组--------");
        //构造稀疏数组：列固定为3，行要看二维数组的非0个数（遍历二维数组拿到）
        int sum = 0;
        for (int[] arr : chessArray1) {
            for (int i : arr) {
                if (i != 0){
                    sum++;
                }
            }
        }
        int[][] lessArray = new int[sum+1][3];//这里我一开始写sum++有问题
        lessArray[0][0] = 11;
        lessArray[0][1] = 11;
        lessArray[0][2] = sum;
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray1[i][j] != 0){
                    count++;
                    lessArray[count][0] = i;
                    lessArray[count][1] = j;
                    lessArray[count][2] = chessArray1[i][j];

                }
            }
        }
        for (int[] ints : lessArray) {
            for (int i : ints) {
                System.out.print("\t"+i);
            }
            System.out.println();
        }
        //todo 1、将稀疏数组持久化到磁盘上

        //todo 2、将磁盘上的文件还原成稀疏数组

        System.out.println("------将稀疏数组还原为二维数组-------");
        int[][] chessArray2 = new int[lessArray[0][0]][lessArray[0][1]];
        for (int i = 1; i <= lessArray[0][2]; i++) { //这里一开始写 i < 有问题
            chessArray2[lessArray[i][0]][lessArray[i][1]] = lessArray[i][2];
        }
        for (int[] arr : chessArray2) {
            for (int i : arr) {
                System.out.print("\t"+i);
            }
            System.out.println();
        }
    }
}
