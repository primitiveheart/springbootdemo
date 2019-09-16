package com.example.springbootapi.controller;

import com.example.springbootapi.annonation.ApiIdempotent;
import com.example.springbootapi.common.CommonResponse;
import com.example.springbootapi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/6/21
 * Time  : 9:10 AM
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @ApiIdempotent
    @PostMapping("testIdempotence")
    public CommonResponse testIdempotence(){
        return testService.testIdempotence();
    }
}
