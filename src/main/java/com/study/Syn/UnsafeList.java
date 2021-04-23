package com.study.Syn;

import java.util.ArrayList;
import java.util.List;

//线程不安全的集合
public class UnsafeList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                //第一次没有获取全部,其余几次获取了全部
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }

        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        System.out.println(list.size());
    }

}
