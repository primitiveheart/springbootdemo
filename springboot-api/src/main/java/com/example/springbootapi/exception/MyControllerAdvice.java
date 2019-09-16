package com.example.springbootapi.exception;

import com.example.springbootapi.common.CommonResponse;
import com.example.springbootapi.common.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/6/25
 * Time  : 7:42 AM
 */
@ControllerAdvice
@Slf4j
public class MyControllerAdvice {
    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public CommonResponse serviceExceptionHandler(ServiceException se) {
        return CommonResponse.error(se.getMsg());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public CommonResponse exceptionHandler(Exception e) {
        log.error("exception: ", e);
        return CommonResponse.error(ResponseCode.SERVER_ERROR.getMsg());
    }
}
