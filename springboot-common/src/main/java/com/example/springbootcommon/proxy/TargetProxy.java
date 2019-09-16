package com.example.springbootcommon.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/8/9
 * Time  : 上午9:13
 */
public class TargetProxy implements InvocationHandler {

    private Object target;

    public TargetProxy(Object target) {
        this.target = target;
    }

    public static Object bind(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new TargetProxy(target));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy begin");
        return method.invoke(target, args);
    }

}
