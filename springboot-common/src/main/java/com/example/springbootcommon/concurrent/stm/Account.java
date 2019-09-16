package com.example.springbootcommon.concurrent.stm;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/17
 * Time  : 7:48 AM
 */
public class Account {
    private TxnRef<Integer> balance;

    public Account(int balance) {
        this.balance = new TxnRef<Integer>(balance);
    }

    public void transfer(Account target, int amt) {
        STM.atomic((txn) -> {
            Integer from = balance.getValue(txn);
            balance.setValue(from - amt, txn);
            Integer to = target.balance.getValue(txn);
            target.balance.setValue(to + amt , txn);
        });
    }
}
