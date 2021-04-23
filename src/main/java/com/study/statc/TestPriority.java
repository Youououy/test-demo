package com.study.statc;


//测试线程的优先级
public class TestPriority {

    public static void main(String[] args) {
        //主线程，默认优先级
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);

        //先设置优先级，再启动
        t1.start();

        t2.setPriority(6);
        t2.start();

        t3.setPriority(2);
        t3.start();

        t4.setPriority(8);
        t4.start();

        t5.setPriority(Thread.MAX_PRIORITY); // MAX_PRIORITY = 10
        t5.start();

    }
}


class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority() );
    }
}