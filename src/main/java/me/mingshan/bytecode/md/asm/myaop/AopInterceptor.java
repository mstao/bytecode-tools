package me.mingshan.bytecode.md.asm.myaop;

public class AopInterceptor {
    public static void before(){
        System.out.println(".......before().......");
    }

    public static void after(){
        System.out.println(".......after().......");
    }
}
