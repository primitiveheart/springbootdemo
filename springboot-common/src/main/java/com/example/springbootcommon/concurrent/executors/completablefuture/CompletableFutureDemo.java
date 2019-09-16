package com.example.springbootcommon.concurrent.executors.completablefuture;

import java.net.Socket;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/14
 * Time  : 3:17 PM
 */
public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            System.out.println("T1: 洗水壶");
            sleep(10, TimeUnit.SECONDS);
            System.out.println("T1: 烧水");
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("T2: 洗茶壶");
            sleep(10, TimeUnit.SECONDS);
            System.out.println("T2: 洗水杯");
            sleep(10, TimeUnit.SECONDS);
            System.out.println("T2: 拿茶叶");
            sleep(10, TimeUnit.SECONDS);
            return "龙井";
        });


        CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf) -> {
            System.out.println("T1: 拿到茶叶: " + tf);
            System.out.println("T1: 泡茶。。。");
            return "上茶：" + tf;
        });

        System.out.println(f3.join());
    }

    static void sleep(int t, TimeUnit u) {
        try {
            u.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
