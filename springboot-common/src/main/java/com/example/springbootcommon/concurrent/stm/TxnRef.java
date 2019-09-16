package com.example.springbootcommon.concurrent.stm;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/17
 * Time  : 7:20 AM
 */
public class TxnRef<T> {
    volatile VersionedRef curRef;
    public TxnRef(T value) {
        this.curRef = new VersionedRef(value, 0L);
    }

    public T getValue(Txn txn) {
        return txn.get(this);
    }

    public void setValue(T value, Txn txn) {
        txn.set(this, value);
    }
}
