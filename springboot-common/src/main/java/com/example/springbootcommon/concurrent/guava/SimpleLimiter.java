package com.example.springbootcommon.concurrent.guava;

import java.util.concurrent.TimeUnit;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/16
 * Time  : 12:06 AM
 */
public class SimpleLimiter {
    // 下一个令牌的时间
    long next = System.nanoTime();

    //  发送令牌的时间间隔
    long interval = 1000000000L;

    // 预占令牌，返回能够获取令牌的时间
    synchronized long reserve(long now) {
        // 请求时间在下一个令牌产生之后
        // 重新计算令牌时间
        if (now > next) {
            // 将下一个令牌时间重置为当前时间
            next = now;
        }
        // 能够获取令牌的时间
        long at = next;
        // 设置下一个令牌的产生时间
        next += interval;
        // 返回线程需要等待的时间
        return Math.max(at, 0L);
    }

    // 申请令牌
    void acquire() {
        // 申请令牌时间
        long now = System.nanoTime();
        // 预占令牌时间
        long at = reserve(now);
        long waitingTime = Math.max(at - now, 0);
        // 按照条件等待
        if (waitingTime > 0) {
            try {
                TimeUnit.NANOSECONDS.sleep(waitingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}