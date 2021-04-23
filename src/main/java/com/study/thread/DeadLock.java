package com.study.thread;

//死锁:多个线程互相拥抱着对方需要的资源,然后形成僵持
public class DeadLock {

    public static void main(String[] args) {
        MakeUp m1 = new MakeUp(0, "赵一帆");
        MakeUp m2 = new MakeUp(1, "张艺");
        m1.start();
        m2.start();
    }

}

//口红
class LipStick{

}
//镜子
class  Mirror{

}

class MakeUp extends  Thread{
    //需要的资源只有一份,用static来保证只有一份
    static LipStick lipStick=new LipStick();
    static Mirror mirror=new Mirror();

    int choice; //选择
    String girlName; //使用化妆品的人

    MakeUp(int choice,String girlName){
        this.choice=choice;
        this.girlName=girlName;
    }

    @Override
    public void run(){

        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆,互相持有对方的锁,就是需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if (choice==0){
            synchronized (lipStick){ //获得口红的锁
                System.out.println(this.girlName+"获得口红的锁");
                Thread.sleep(1000);
            }
            synchronized (mirror) { //一秒钟后获得镜子的锁
                System.out.println(this.girlName + "获得镜子的锁");
            }
        }else {
            synchronized (mirror){ //获得口红的锁
                System.out.println(this.girlName+"获得镜子的锁");
                Thread.sleep(2000);
            }
            synchronized (lipStick) { //两秒钟后获得镜子的锁
                System.out.println(this.girlName + "获得口红的锁");
            }
        }
    }
}
