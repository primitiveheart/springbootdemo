package com.example.springbootcommon.concurrent.stm;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/17
 * Time  : 7:21 AM
 */
public interface Txn {
    <T> T get(TxnRef<T> tTxnRef);

    <T> void set(TxnRef<T> tTxnRef, T value);
}
