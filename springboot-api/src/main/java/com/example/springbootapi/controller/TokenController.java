package com.example.springbootapi.controller;

import com.example.springbootapi.common.CommonResponse;
import com.example.springbootapi.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/6/21
 * Time  : 9:07 AM
 */
@Controller
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @GetMapping
    @ResponseBody
    public CommonResponse token() {
        return tokenService.createToken();
    }
}
