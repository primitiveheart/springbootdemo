package com.example.springbootapi.exception;

import lombok.Data;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/6/21
 * Time  : 9:02 AM
 */
@Data
public class ServiceException extends RuntimeException {

    private String msg;
    private String code;

    public ServiceException(){}

    public ServiceException(String msg){
        this.msg = msg;
    }

    public ServiceException(String msg, String code){
        this.msg = msg;
        this.code = code;
    }

}
