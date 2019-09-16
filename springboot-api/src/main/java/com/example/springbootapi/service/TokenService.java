package com.example.springbootapi.service;

import com.example.springbootapi.common.CommonResponse;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/6/20
 * Time  : 10:18 PM
 */
@Component
public interface TokenService {
    CommonResponse createToken();
    void checkToken(HttpServletRequest request);
}
