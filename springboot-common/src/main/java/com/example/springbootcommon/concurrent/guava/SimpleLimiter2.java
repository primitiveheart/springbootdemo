package com.example.springbootcommon.concurrent.guava;

import java.util.concurrent.TimeUnit;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/16
 * Time  : 6:59 AM
 */
public class SimpleLimiter2 {
    // 令牌桶中的数量
    long storePermits;
    // 令牌桶的容量
    long maxPermits;
    // 下一个令牌产生的间隔
    long next = System.nanoTime();
    // 发送令牌的时间间隔
    long interval = 1000000000;

    // 请求时间在下一个令牌产生之后，则
    // 1 重新计算令牌桶的数量
    // 2 将下一个令牌发放的时间重置为当前时间
    void resync(long now) {
        if (now > next) {
            // 产生令牌桶的数量
            long newPermits = (now - next) / interval;
            // 新令牌增加到令牌桶中
            storePermits = Math.min(maxPermits, storePermits + newPermits);
            // 将下一个令牌产生的时间重置为当前时间
            next = now;
        }
    }

    // 预占令牌，能够返回获取令牌的时间
    synchronized long reserve(long now) {
        resync(now);
        // 能够获取产生令牌的时间
        long at = next;
        // 令牌桶中能提供的令牌
        long fb = Math.min(1, storePermits);
        // 令牌净需求：首先减去令牌桶中的数量
        long nr = 1 - fb;
        // 重新计算下一令牌产生时间
        next = next + nr * interval;
        // 重新计算令牌桶中的数量
        this.storePermits -= fb;
        return at;
    }

    void acquire() {
        // 申请令牌的时间
        long now = System.nanoTime();
        // 预占令牌
        long at = reserve(now);
        long waitTime = Math.max(at - now, 0);
        // 按照条件等待
        try {
            TimeUnit.NANOSECONDS.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
