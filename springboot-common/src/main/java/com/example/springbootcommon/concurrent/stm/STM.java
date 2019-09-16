package com.example.springbootcommon.concurrent.stm;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/17
 * Time  : 7:30 AM
 */
public final class STM {
    static final Object commitLock = new Object();
    private STM(){}
    public static void atomic(TxnRunnable action) {
        boolean committed = false;
        while (!committed) {
            STMTxn txn = new STMTxn();
            action.run(txn);
            committed = txn.commit();
        }
    }
}
