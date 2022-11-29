package me.mingshan.bytecode.md.asm.aop.test;

import me.mingshan.bytecode.md.asm.aop.Enhancer;

import java.lang.reflect.Method;

public class EnhanceTest {
    public static void main(String[] args) {
        testGenByteCodes();
    }

    public static void testGenByteCodes() {
        Enhancer enhancer = new Enhancer();
        enhancer.setTargetClass(Person.class);
        enhancer.setAdviceListener(new TestAdviceListener());

        try {
            Object object = enhancer.enhance();
            Method method = object.getClass().getMethod("sayHello", String.class);
            System.out.println(method.invoke(object, "jinjin"));

            Method method1 = object.getClass().getMethod("getName");
            System.out.println(method1.invoke(object));

//            Method method2 = object.getClass().getMethod("getGender");
//            System.out.println(method2.invoke(object));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
