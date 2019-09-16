package com.example.springbootcommon.concurrent.executors.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/14
 * Time  : 2:45 PM
 */
public class FutureTaskDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task2 = new FutureTask<>(new Task2());

        FutureTask<String> task1 = new FutureTask<>(new Task1(task2));

        Thread thread = new Thread(task1);
        thread.start();
        Thread thread2 = new Thread(task2);
        thread2.start();
        System.out.println(task1.get());
    }
}

class Task1 implements Callable<String> {

    private FutureTask<String> futureTask2;

    public Task1(FutureTask<String> futureTask2) {
        this.futureTask2 = futureTask2;
    }

    @Override
    public String call() throws Exception {
        System.out.println("T1: 洗水壶");
        Thread.sleep(100);

        System.out.println("T1: 烧水");
        Thread.sleep(100);

        String s = futureTask2.get();

        System.out.println("T1: 拿到茶叶" + s);

        System.out.println("T1: 泡茶");

        return "上茶";
    }
}

class Task2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("T2: 洗茶壶");
        Thread.sleep(100);

        System.out.println("T2: 洗茶杯");
        Thread.sleep(100);

        System.out.println("T2: 拿茶叶");
        Thread.sleep(100);

        return " 龙井 ";
    }
}
