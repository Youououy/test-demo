package com.study.demo2;


//静态代理模式：
//真实对象和代理对象都要实现同一个接口
//代理对象要代理真实角色
public class StaticProxy {

    public static void main(String[] args) {
        StudyMe studyMe=new StudyMe(new You());
        studyMe.HappyMarry();
    }
}

interface Marry{

    void HappyMarry();
}

//真实角色
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("offer了，超开心");
    }
}

//代理角色，帮我学习
class StudyMe implements Marry{

    private  Marry marry;

    public StudyMe (Marry marry){

        this.marry=marry;

    }
    @Override
    public void HappyMarry() {
        before();
        this.marry.HappyMarry();
        after();
    }

    private void before(){
        System.out.println("offer之前，帮我学习");
    }
    private void after(){
        System.out.println("offer之后，努力学习");
    }

}
