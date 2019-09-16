package com.example.springbootapi.impl;

import com.example.springbootapi.common.CommonResponse;
import com.example.springbootapi.service.TestService;
import org.springframework.stereotype.Component;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/6/21
 * Time  : 9:12 AM
 */
@Component
public class TestServiceImpl implements TestService {
    @Override
    public CommonResponse testIdempotence() {
        return CommonResponse.success("testIdempotent: success");
    }
}
