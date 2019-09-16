package com.example.springbootcommon.test;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/8/16
 * Time  : 上午8:10
 */
public class Test {

    public static final List<String> result = Lists.newArrayList();

    static {
        result.add("");
    }

    public static void main(String[] args) {
       new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println("thread1");
           }
       }).start();
       new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println("thread2");
           }
       }).start();

    }

    public void test() {
        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        traverse(list);
    }

    public static void traverse(List<String> list) {
        for (int i=0; i < list.size(); i++ ) {
            String middle = list.get(i);
            List<String> temp = Lists.newArrayList();
            for (int j=0; j < result.size(); j++) {
                temp.add(result.get(j) + (!result.get(j).equals("") ? "," : "") + middle);
            }
            result.addAll(temp);
            temp.clear();
        }
        for (String s : result) {
            System.out.println(s);
        }
    }
}
