package com.example.springbootcommon.concurrent.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/15
 * Time  : 9:00 AM
 */
public class RateLimiterDemo {
    private static long pre;
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(2.0);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        pre = System.nanoTime();
        for (int i=0; i<20; i++) {
            rateLimiter.acquire();
            executorService.execute(()->{
                long cur = System.nanoTime();
                System.out.println((cur - pre) / 1000000);
                pre = cur;
            });
        }
    }
}
