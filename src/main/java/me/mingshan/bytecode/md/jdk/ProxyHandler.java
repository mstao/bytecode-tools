package me.mingshan.bytecode.md.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author hanjuntao
 * @date 2023/2/8
 */
public class ProxyHandler implements InvocationHandler {

    private Object targetObject;

    public ProxyHandler(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("日志开始");
        Object invoke = method.invoke(targetObject, args);
        System.out.println("日志结束");
        return invoke;
    }
}
