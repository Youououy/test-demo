package com.study.statc;

//测试守护线程
public class TestDacmon {

    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread thread = new Thread(god);
        thread.setDaemon(true); //默认false，表示用户线程，正常的线程都是用户线程

        thread.start(); //God开启守护线程

        new Thread(you).start(); //用户线程启动
    }

}

class  God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑你");
        }
    }
}

class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("开心每一天");
        }
        System.out.println("Hello,World!");
    }
}
