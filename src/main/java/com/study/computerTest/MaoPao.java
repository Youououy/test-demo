package com.study.computerTest;

public class MaoPao {

    public static void main(String[] args) {

        int[] arr=new int[]{-1,-3,23,2,7,9,8};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {  //arr.length-1-i  因为下面是arr[j+1]
                if (arr[j]>arr[j+1]){ //如果下标j(前面) > j+1(后面一个)
                    int temp=arr[j];  //临时变量
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        //遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
    }

}
