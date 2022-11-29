package me.mingshan.bytecode.md.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Demo1Interceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long now = System.currentTimeMillis();

        try {
            return methodProxy.invokeSuper(o, objects);
        } finally {
            System.out.println("方法：" + method.getName()
                    + "执行耗时：" + (System.currentTimeMillis() - now));
        }
    }
}
