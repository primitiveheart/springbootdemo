package com.example.springbootcommon.concurrent.executors.ThreadLocalDemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/14
 * Time  : 7:51 PM
 */
public class ThreadSafeDate {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println();

                System.out.println(SafeDate.get());
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());

                System.out.println(SafeDate.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
                System.out.println(SafeDate.get());
            }
        }).start();
        System.out.println(Thread.currentThread());
        System.out.println(SafeDate.get());
    }

//    static class SafeDate {
//        private static final ThreadLocal<DateFormat> tl = ThreadLocal.withInitial(()->
//                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//
//        static DateFormat get() {
//            return tl.get();
//        }
//    }

    static class SafeDate {
        // 定义 ThreadLocal 变量
        static final ThreadLocal<DateFormat>
                tl=ThreadLocal.withInitial(
                ()-> new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss"));

        static DateFormat get(){
            return tl.get();
        }
    }
    // 不同线程执行下面代码
//// 返回的 df 是不同的
//    DateFormat df =
//            SafeDateFormat.get()；

}


