package com.example.springbootapi.impl;

import com.example.springbootapi.common.CommonResponse;
import com.example.springbootapi.common.Constant;
import com.example.springbootapi.common.ResponseCode;
import com.example.springbootapi.exception.ServiceException;
import com.example.springbootapi.service.TokenService;
import com.example.springbootapi.util.JedisUtil;
import com.example.springbootapi.util.RandomUtil;
//import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/6/20
 * Time  : 10:19 PM
 */
@Component
public class TokenServiceImpl implements TokenService {

    private static final String TOKEN_NAME = "token";

    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public void checkToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_NAME);
        if (StringUtils.isBlank(token)) {// header中不存在token
            token = request.getParameter(TOKEN_NAME);
            if (StringUtils.isBlank(token)) {// parameter中也不存在token
                throw new ServiceException(ResponseCode.ILLEGAL_ARGUMENT.getMsg());
            }
        }

        if (!jedisUtil.exists(token)) {
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }

        Long del = jedisUtil.del(token);
        if (del <= 0) {
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
    }

    @Override
    public CommonResponse<String> createToken() {
        String str = RandomUtil.UUID32();
        StringBuilder token = new StringBuilder();
        token.append(Constant.Redis.TOKEN_PREFIX).append(str);
//        jedisUtil.set(token.toString(), token.toString(), Constant.Redis.EXPIRE_TIME_HOUR);
        jedisUtil.set(token.toString(), token.toString());
        return CommonResponse.success(token.toString());
    }
}
