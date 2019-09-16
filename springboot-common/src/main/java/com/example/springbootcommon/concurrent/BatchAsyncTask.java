package com.example.springbootcommon.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/13
 * Time  : 4:11 PM
 */
public class BatchAsyncTask {
    public static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static String getPriceByS1() {
        return "s1";
    }

    public static String getPriceByS2() {
        return "s2";
    }

    public static String getPriceByS3() {
        return "s3";
    }

    public static void save1(String s) {
        System.out.println(s);
    }

    public static void save2(String s) {
        System.out.println(s);
    }

    public static void save3(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       Future<String> future1 = executorService.submit(() -> getPriceByS1());
       Future<String> future2 = executorService.submit(() -> getPriceByS2());
       Future<String> future3 = executorService.submit(() -> getPriceByS2());

       String s1 = future1.get();
       executorService.execute(() -> save1(s1));
       String s2 = future2.get();
       executorService.execute(() -> save2(s2));
       String s3 = future3.get();
       executorService.execute(() -> save3(s3));
    }
}
