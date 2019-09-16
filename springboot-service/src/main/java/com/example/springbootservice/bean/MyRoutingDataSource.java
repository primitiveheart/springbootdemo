package com.example.springbootservice.bean;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/6/25
 * Time  : 8:49 AM
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource{
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }
}
