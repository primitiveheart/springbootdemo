package com.example.springbootcommon.concurrent.other;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/18
 * Time  : 11:34 PM
 */
public class TestMultiThread {
    private static long count = 0;

    public static long add10k() {
        int index = 0;
        while (index++ < 10000) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                add10k();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                add10k();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
