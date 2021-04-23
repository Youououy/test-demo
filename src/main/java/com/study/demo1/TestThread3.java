package com.study.demo1;


//创建线程2：实现runnalble接口，重写run方法，执行线程需要丢入runnable接口实现类，调用start方法
public class TestThread3 implements Runnable {

    @Override
    public void  run(){
        //run方法线程体
        for (int i = 0; i < 100; i++) {
            System.out.println("我在看你李刚----"+i);
        }
    }

    public static void main(String[] args) {
        //main线程，主线程

        //创建runnable接口的实现类对象
        TestThread3 thread3 = new TestThread3();
        //创建线程对象，通过线程对象来开启我们的线程，代理
        Thread thread = new Thread(thread3);
        //调用start()方法，开启线程
        thread.start();

        //合并一行代码解决
        // new Thread(thread).start();


        for (int i = 0; i < 2000; i++) {
            System.out.println("我在学习---"+i);
        }

    }
}
