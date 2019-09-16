package com.example.springbootapi.controller;

import com.example.springbootapi.common.CommonResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/31
 * Time  : 5:19 PM
 */
@RestController
@RequestMapping("/list")
public class ListController {

    @RequestMapping("/")
    public CommonResponse list(List<String> test){
        System.out.println(test);
        return CommonResponse.success(null);
    }

}
