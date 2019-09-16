package com.example.springbootcommon.test;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/8/16
 * Time  : 上午8:09
 */
public class SuperClass {
    public static int value = 123;
    static {
        System.out.println("super class initial");
    }
}
