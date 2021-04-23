package com.study.demo1;

//多个线程同时操作同一个对象
//买火车票的例子
public class TestThread5 implements Runnable {


    //票数
    private int ticketNums=10;


    @Override
    public void run() {
        while (true){
            if (ticketNums<=0){
                break;
            }
            //模拟延时
          /*  try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println(Thread.currentThread().getName()+"-->拿到了第"+ticketNums--+"票");
        }
    }

    public static void main(String[] args) {
        TestThread5 thread5 = new TestThread5();

        new Thread(thread5,"小明").start();
        new Thread(thread5,"小红").start();
        new Thread(thread5,"黄牛党").start();
    }

}
