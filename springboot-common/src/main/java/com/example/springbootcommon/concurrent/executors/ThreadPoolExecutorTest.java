package com.example.springbootcommon.concurrent.executors;

import org.springframework.lang.NonNull;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/14
 * Time  : 2:03 PM
 */
public class ThreadPoolExecutorTest {
    public static ThreadPoolExecutor threadPoolExecutor;

    static {
        threadPoolExecutor = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2), new RealNameThreadFactory("测试"),
                new ThreadPoolExecutor.AbortPolicy());
    }


    static class RealNameThreadFactory implements ThreadFactory {

        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final String namePrefix;

        public RealNameThreadFactory(@NonNull String prefix) {
            SecurityManager sm = System.getSecurityManager();
            group = (sm != null) ? sm.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = prefix + "-poolnumber: " + poolNumber.getAndIncrement() + "-threadnumber: ";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            return thread;
        }
    }

    public static void main(String[] args) {
        threadPoolExecutor.execute(() -> {
            System.out.println("hell" + 1/ 0);
        });
    }
}
