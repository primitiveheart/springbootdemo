package com.example.springbootcommon.concurrent.executors.ThreadLocalDemo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/14
 * Time  : 7:45 PM
 */
public class ThreadId {
    private static final AtomicLong nextId = new AtomicLong(0);
    private static ThreadLocal<Long> threadLocal = ThreadLocal.withInitial(() -> nextId.getAndIncrement());
    public static Long get() {
        return threadLocal.get();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(get());
                System.out.println(get());
            }
        }).start();

        System.out.println(get());
    }
}
