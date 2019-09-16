package com.example.springbootcommon.concurrent.stm;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/17
 * Time  : 7:18 AM
 */
public final class VersionedRef<T> {
    final T value;
    final long version;

    public VersionedRef(T value, long version) {
        this.value = value;
        this.version = version;
    }
}
