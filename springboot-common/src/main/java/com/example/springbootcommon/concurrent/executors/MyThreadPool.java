package com.example.springbootcommon.concurrent.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/14
 * Time  : 1:34 PM
 */
public class MyThreadPool {
    BlockingQueue<Runnable> workQueue;

    List<WorkThread> threads = new ArrayList<>();

    public MyThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        for (int i=0; i < poolSize; i++) {
            WorkThread workThread = new WorkThread();
            workThread.start();
            threads.add(workThread);
        }

    }

    public void submit(Runnable task) {
        workQueue.add(task);
    }


    class WorkThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Runnable task = workQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(2);
        MyThreadPool myThreadPool = new MyThreadPool(2, workQueue);
        myThreadPool.submit(() -> {
            System.out.println("zhou " + 7 / 0);
        });
    }
}

