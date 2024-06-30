package com.wm.project.project;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 多线程执行，线程池阻塞
 */
@SpringBootTest
public class ThreadDemo2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(4); // 创建线程池

        List<Future<Integer>> resultList = new ArrayList<>(); // 用于存储每个任务的返回值

        for (int i = 0; i < 10; i++) {
            if(i==2){
                Thread.sleep(10000);
            }

            int finalI = i;

            Callable<Integer> task = () -> {
                return finalI;
            };
            Future<Integer> integer = executor.submit(task) ;// 提交任务，并获取其返回值
            resultList.add(integer); // 将返回值添加到结果集中
            System.out.println(i);
        }

        executor.shutdown(); // 关闭线程池

        while (!executor.isTerminated()) { // 等待所有任务完成
            Thread.sleep(100);
        }
        List<Integer> collect = new ArrayList<>();
        for (Future<Integer> integerFuture : resultList) {
            Integer integer = integerFuture.get();
            collect.add(integer);
        }
        System.out.println(collect);
    }
}
