package com.study.statc;

//测试线程的状态
public class TestStatc {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i=0;i<5;i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("//////");
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state); //NEW

        //观察启动后
        thread.start(); //开启线程
        state = thread.getState();
        System.out.println(state);  //RUN

        while (state != Thread.State.TERMINATED){ //只要线程不终止，就一直输出状态
            Thread.sleep(100);
            state = thread.getState();  //更新线程状态
            System.out.println(state); //输出状态
        }
        //销毁线程后，不能启动了
       // thread.start();


    }


}
