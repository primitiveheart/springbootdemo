package com.example.springbootcommon.concurrent.stm;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/16
 * Time  : 11:28 PM
 */
public class UnsafeAccount {
    private long balance;

    public UnsafeAccount(long balance) {
        this.balance = balance;
    }

    public void tranfer(UnsafeAccount target, long amt) {
        if (this.balance > amt) {
            this.balance -= amt;
            target.balance += amt;
        }
    }
}
