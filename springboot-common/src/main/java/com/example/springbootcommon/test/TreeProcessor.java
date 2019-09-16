package com.example.springbootcommon.test;

import java.lang.reflect.Method;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/8/22
 * Time  : 下午12:54
 */
public class TreeProcessor {
    public void parseMethod(Class<?> clazz) throws Exception {
        Object obj = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Tree annotation = method.getAnnotation(Tree.class);
            if (annotation != null) {
                method.invoke(obj, annotation.name());
            }
        }
    }
}
