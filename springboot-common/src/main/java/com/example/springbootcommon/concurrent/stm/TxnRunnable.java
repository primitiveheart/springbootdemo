package com.example.springbootcommon.concurrent.stm;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/17
 * Time  : 7:36 AM
 */
@FunctionalInterface
public interface TxnRunnable {
    void run(Txn txn);
}
