package com.example.springbootcommon.test;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/8/23
 * Time  : 上午8:40
 */
public class StaticTest {
    public static void main(String[] args) {
        staticFunction();
    }

    static StaticTest st = new StaticTest();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTest () {
        System.out.println("3");
        System.out.println("a = " + a + " b= " + b);
    }

    static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    static int b = 112;
}
