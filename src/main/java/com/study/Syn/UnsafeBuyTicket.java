package com.study.Syn;

public class UnsafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"我").start();
        new Thread(buyTicket,"你++").start();
        new Thread(buyTicket,"黄牛党").start();
    }

}

class BuyTicket implements Runnable{

    private int ticketNums=10;
    boolean flag=true;  //外部停止方式

    @Override
    public void run() {
        //买票
        while(flag){
            buy();
        }
    }

    private synchronized void buy(){
        //判断是否有票
        if (ticketNums<=0){
            flag=false;
            return;
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //买票
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }
}
