package com.example.springbootcommon.concurrent;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/13
 * Time  : 11:45 PM
 */
public class ForkJoinTest {


    // 归并排序
    // 归并排序分为两个部分：第一部分是分解，第二部分是合并结果
    // 传统的大量数据归并排序
    public static long[] mergeSort(long[] arrs) {
        if (arrs.length < 2) return arrs;
        int mid = arrs.length / 2;
        long[] left = Arrays.copyOfRange(arrs, 0, mid);
        long[] right = Arrays.copyOfRange(arrs, mid, arrs.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static long[] merge(long[] left, long[] right) {
        long[] result = new long[left.length + right.length];
        for (int l=0, r =0, m=0; m < result.length; m++) {
            if (l >= left.length) {
                result[m] = right[r++];
            } else if (r >= right.length) {
                result[m] = left[l++];
            } else if (left[l] > right[r]) {
                result[m] = right[r++];
            } else {
                result[m] = left[l++];
            }
        }
        return result;
    }



    public static void main(String[] args) {
        long[] unSort = new long[100000000];
        for (int i=0; i < 100000000; i++) {
            unSort[i] = (long) (Math.random() * 100000000);
        }
        long startTime = System.currentTimeMillis();

//        mergeSort(unSort); 耗时 27152
        System.out.println(Runtime.getRuntime().availableProcessors());
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        MergeSort mergeSort = new MergeSort(unSort);
        forkJoinPool.invoke(mergeSort);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }


    static class MergeSort extends RecursiveTask<long[]> {
        private long[] arrs;

        public MergeSort(long[] arrs) {
            this.arrs = arrs;
        }
        @Override
        protected long[] compute() {
            if (arrs.length < 2) return arrs;
            int mid = arrs.length / 2;
            MergeSort left = new MergeSort(Arrays.copyOfRange(arrs, 0, mid));
            left.fork();
            MergeSort right = new MergeSort(Arrays.copyOfRange(arrs, mid, arrs.length));
            return merge(right.compute(), left.join());
        }
    }

}


