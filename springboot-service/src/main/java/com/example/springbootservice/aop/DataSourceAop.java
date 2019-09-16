package com.example.springbootservice.aop;

import com.example.springbootservice.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/6/26
 * Time  : 7:27 AM
 */
@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.example.springbootservice.annonation.Master)"
//            "execution(* com.example.springbootapi.service..*.select*(..))" +
//            "|| execution(* com.example.springbootapi.service..*.select*(..))"
    )
    public void readPointcut(){};

    @Pointcut("@annotation(com.example.springbootservice.annonation.Master)"
//            "|| execution(* com.example.springbootapi.service..*.insert*(..))" +
//            "|| execution(* com.example.springbootapi.service..*.save*(..))"
    )
    public void writePointcut(){};


    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }
}
