package me.mingshan.bytecode.asm;

import me.mingshan.bytecode.classloader.MyClassLoader;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String path = "D:\\develop\\code\\bytecode-tools\\src\\main\\java\\me\\mingshan\\bytecode\\asm\\Demo.class";

        MyClassLoader myClassLoader = new MyClassLoader(path);
        Class<?> clazz = myClassLoader.loadClass("me.mingshan.bytecode.asm.Demo");

        /**
         * Caused by: java.lang.NoSuchMethodException: me.mingshan.bytecode.asm.Demo.<init>()
         * 	at java.lang.Class.getConstructor0(Class.java:3082)
         * 	at java.lang.Class.newInstance(Class.java:412)
         * 	... 1 more
         */
        Object o = clazz.newInstance();

    }
}
