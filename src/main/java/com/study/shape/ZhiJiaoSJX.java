package com.study.shape;

public class ZhiJiaoSJX {

    public static void main(String[] args) {
        int[] a=new int[10];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

}
