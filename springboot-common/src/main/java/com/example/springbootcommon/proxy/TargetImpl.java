package com.example.springbootcommon.proxy;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/8/9
 * Time  : 上午9:11
 */
public class TargetImpl implements Target {
    @Override
    public void execute() {
        System.out.println("hello proxy");
    }
}
