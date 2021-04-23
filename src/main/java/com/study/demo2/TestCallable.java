package com.study.demo2;

import com.study.demo1.TestThread2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

//线程创建方式3：实现callable接口
public class TestCallable implements Callable<Boolean> {

    private String url; //网络图片路径
    private String name; //保存的文件名

    public TestCallable(String url,String name){
        this.url=url;
        this.name=name;
    }

    //下载图片线程的执行体
    @Override
    public Boolean call(){
        WebDownloader2 downloader2 = new WebDownloader2();
        downloader2.downloader(url,name);
        System.out.println("下载的文件名为:"+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://img-blog.csdnimg.cn/20200913162753746.png","q2.jpg");
        TestCallable t2 = new TestCallable("https://img-blog.csdnimg.cn/20200913162902205.png","w2.jpg");
        TestCallable t3 = new TestCallable("https://img-blog.csdnimg.cn/20200913162931554.png","e2.jpg");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);
        //获取结果
        boolean rs1=r1.get();
        boolean rs2=r2.get();
        boolean rs3=r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);
        //关闭服务
        ser.shutdownNow();

    }

}

//下载器
class WebDownloader2{
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