package com.study.shape;

public class PingXingSBX2 {
    public static void main(String[] args) {
        int [] a=new int[10];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length-i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < a.length; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }
}
