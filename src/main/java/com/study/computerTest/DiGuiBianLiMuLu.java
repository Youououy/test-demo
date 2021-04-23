package com.study.computerTest;

import java.io.File;

public class DiGuiBianLiMuLu {

    public static void main(String[] args) {
        /*String string = new String("  TESTaaa   ");
        //string.toLowerCase();
        string.trim();
        System.out.println(string);*/

        String path="url";
        listFile(path);

    }

    public static void  listFile(String path){
        File file = new File(path);
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                String name = files[i].getName();
                if (name.trim().toLowerCase().endsWith(".java")){
                    System.out.println("files:"+name);
                }
                if (files[i].isDirectory()){
                    listFile(files[i].getPath());
                }
            }
        }

    }

}
