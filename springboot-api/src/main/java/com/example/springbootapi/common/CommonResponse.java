package com.example.springbootapi.common;

import lombok.Data;

import java.io.Serializable;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/6/20
 * Time  : 10:21 PM
 */
@Data
public class CommonResponse<T> implements Serializable {
    private T data;
    private String msg;
    private Integer code;

    public CommonResponse(Integer code , String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> CommonResponse<T>  success() {
        return new CommonResponse(ResponseCode.SUCCESS.getCode(), null, null);
    }

    public static <T> CommonResponse<T>  success(String msg) {
        return new CommonResponse(ResponseCode.SUCCESS.getCode(), msg, null);
    }

    public static <T> CommonResponse<T>  success(T data) {
        return new CommonResponse(ResponseCode.SUCCESS.getCode(), null, data);
    }

    public static <T> CommonResponse<T>  success(String msg, T data) {
        return new CommonResponse(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> CommonResponse<T>  error() {
        return new CommonResponse(ResponseCode.ERROR.getCode(), null, null);
    }

    public static <T> CommonResponse<T>  error(String msg) {
        return new CommonResponse(ResponseCode.ERROR.getCode(), msg, null);
    }

    public static <T> CommonResponse<T>  error(T data) {
        return new CommonResponse(ResponseCode.ERROR.getCode(), null, data);
    }

    public static <T> CommonResponse<T>  error(String msg, T data) {
        return new CommonResponse(ResponseCode.ERROR.getCode(), msg, data);
    }

}
