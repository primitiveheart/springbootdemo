package com.example.springbootcommon.concurrent.art.container;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/18
 * Time  : 7:07 AM
 */
public class HashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        final Map<String ,String> map = new HashMap<>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i< 1000000; i++) {
                    System.out.println(i);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(UUID.randomUUID().toString());
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();
        System.out.println("Sss");
    }
}
