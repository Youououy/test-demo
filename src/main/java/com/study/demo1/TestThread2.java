package com.study.demo1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//实现多线程同步下载图片
public class TestThread2 extends Thread{

    private String url; //网络图片路径
    private String name; //保存的文件名

    public TestThread2(String url,String name){
        this.url=url;
        this.name=name;
    }

    //下载图片线程的执行体
    @Override
    public void  run(){
        WebDownloader downloader = new WebDownloader();
        downloader.downloader(url,name);
        System.out.println("下载的文件名为:"+name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://img-blog.csdnimg.cn/20200913162753746.png","q.jpg");
        TestThread2 t2 = new TestThread2("https://img-blog.csdnimg.cn/20200913162902205.png","w.jpg");
        TestThread2 t3 = new TestThread2("https://img-blog.csdnimg.cn/20200913162931554.png","e.jpg");
        t1.start();
        t2.start();
        t3.start();
    }

}
//下载器
class WebDownloader{
    //下载方法
    public  void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}
