package com.example.springbootapi.service;


import com.example.springbootapi.common.CommonResponse;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/6/21
 * Time  : 9:12 AM
 */
public interface TestService {
     CommonResponse testIdempotence();
}
