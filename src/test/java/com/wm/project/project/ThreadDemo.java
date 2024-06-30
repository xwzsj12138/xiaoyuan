package com.example.hiberdemo.job;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@SpringBootTest
public class ThreadDemo {
    public static  List<String> list ;

    public static Hashtable<String,String> hashtable = new Hashtable<>();

    public static Boolean flagFinl = true;

    public static void main(String[] args) {
        new ThreadDemo().doTask();
    }
    @PostConstruct
    public void init(){
        list  = Arrays.asList("张三", "李四", "王五");
    }
    /***
     * 需求 已知ArrayList用户长度，
     *
     * ***/
//    @Scheduled(fixedRate = 2000)
    public void doTask(){
        list  = Arrays.asList("张三", "李四", "王五");
        try {
            for (Map.Entry<String, String> stringStringEntry : hashtable.entrySet()) {
                if(!"flag".equals(stringStringEntry.getValue())){
                    flagFinl =true;
                }
            }
            if(flagFinl){
                flagFinl = false ;
                System.out.println("定时任务开始执行==============");
                aa();

            }
        }catch (Exception e){
            e.printStackTrace();

            flagFinl = true;
        }

    }


    public static void aa(){
        for (String s : list) {
            if(!"flag".equals(hashtable.get(s))){
                Thread thread = new Thread(() -> {
                    hashtable.put(s,"flag");
                    bb(s);
                    hashtable.put(s,"isOk");
                });
                thread.start();
            }
        }
    }

    public static void bb(String s){

        if(s.equals("王五")){
            try {
                Thread.sleep(1000*10);
                System.out.println("wangwu睡醒了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(s.equals("张三")){
            try {
                Thread.sleep(1000*10*2);
                System.out.println("张三谁信了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(s.equals("李四")){
            try {
                Thread.sleep(1000*3);
                System.out.println("李四谁信了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(s+Thread.currentThread().getName());
        hashtable.put(s,"已经执行完毕");
    }
}
