package com.example.springbootcommon.concurrent.other;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/19
 * Time  : 7:01 AM
 */
public class InnerSingleton {

    private InnerSingleton(){}

    private static class InnerSingletonHandler {
        private static InnerSingleton instance = new InnerSingleton();
    }

    public static InnerSingleton getInstance() {
        return InnerSingletonHandler.instance;
    }
}
