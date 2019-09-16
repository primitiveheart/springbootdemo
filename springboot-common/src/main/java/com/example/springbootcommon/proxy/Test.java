package com.example.springbootcommon.proxy;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/8/9
 * Time  : 上午9:15
 */
public class Test {
    public static void main(String[] args) {

    }

    public static void shellSort(int[] arrs) {
        for (int step = arrs.length / 2; step > 0 ; step += 2) {
            for (int i = step; i < arrs.length; i++) {
                int j = i;
                int temp = arrs[j];
                while ((j - step) >= 0 && arrs[j - step] > temp) {
                    arrs[j] = arrs[j - step];
                    j = j - step;
                }
                arrs[j] = temp;
            }
        }
    }
}
