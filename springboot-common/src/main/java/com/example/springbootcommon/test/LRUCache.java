package com.example.springbootcommon.test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/8/22
 * Time  : 上午9:16
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int limit;

    public LRUCache() {

    }

    public LRUCache(int limit) {
        super(limit, 1f, true);
        this.limit = limit;
    }

    public V save(K k, V v) {
        return put(k, v);
    }

    public V getOne(K k) {
        return get(k);
    }

    public boolean exist(K k) {
        return containsKey(k);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > limit;
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(3);
        for (int i = 0; i< 10; i++) {
            lruCache.save(i , i * i);
        }
        System.out.println(lruCache);
    }
}
