package me.mingshan.bytecode.md.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class CglibTest {
    static {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./temp");
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Demo1.class);
        enhancer.setCallback(new Demo1Interceptor());
        Demo1 demo1 = (Demo1) enhancer.create();
        demo1.say();
    }
}
