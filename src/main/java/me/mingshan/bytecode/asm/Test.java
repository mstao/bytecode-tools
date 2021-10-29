package me.mingshan.bytecode.asm;

import me.mingshan.bytecode.classloader.MyClassLoader;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String path = "E:\\D\\develop\\MY\\CODE\\bytecode-tools\\src\\main\\java\\me\\mingshan\\bytecode\\asm\\Demo.class";

        MyClassLoader myClassLoader = new MyClassLoader(path);
        Class<?> clazz = myClassLoader.loadClass("me.mingshan.bytecode.asm.Demo");

        /*
         * Caused by: java.lang.NoSuchMethodException: me.mingshan.bytecode.asm.Demo.<init>()
         * 	at java.lang.Class.getConstructor0(Class.java:3082)
         * 	at java.lang.Class.newInstance(Class.java:412)
         * 	... 1 more
         */
        Object o = clazz.newInstance();

        /**
         * Exception in thread "main" java.lang.ClassFormatError: Illegal class name "me.mingshan.bytecode.asm.Demo" in class file me/mingshan/bytecode/asm/Demo
         * 	at java.lang.ClassLoader.defineClass1(Native Method)
         * 	at java.lang.ClassLoader.defineClass(ClassLoader.java:756)
         * 	at java.lang.ClassLoader.defineClass(ClassLoader.java:635)
         * 	at me.mingshan.bytecode.classloader.MyClassLoader.findClass(MyClassLoader.java:38)
         * 	at java.lang.ClassLoader.loadClass(ClassLoader.java:418)
         * 	at java.lang.ClassLoader.loadClass(ClassLoader.java:351)
         * 	at me.mingshan.bytecode.asm.Test.main(Test.java:10)
         */

    }
}
