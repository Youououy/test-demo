package com.study.digui;

public class Demo01 {

    public static void main(String[] args) {

        /*String string = "长亭外 古道边 芳草碧连天 晚风拂柳笛声残 夕阳山外山";
        String[] strings1 = string.split(" ");
        for (int i = 0; i < strings1.length; i++) {
            System.out.println(strings1[i]);
        }
*/

        String s1 = "q w e r t   ";
        System.out.println(s1.replace(" ", ""));

        System.out.println(sumNum(10));
        System.out.println(sumNum1(100));

        new Demo01().aa(1,2);
        new Demo01().aa(1.1,2.2);

    }

    private static int sumNum(int n){
        if (n==1){
            return 1;
        }
        return n+sumNum(n-1);
    }


    private static int sumNum1(int n){
        if (n==1){
            return 1;
        }
        return n+sumNum1(n-1);
    }

    public void aa(int a,int n){
        System.out.println(1);
    }
    public void aa(double b,double c){
        System.out.println(2);

    }

}
