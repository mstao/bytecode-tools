package me.mingshan.bytecode.asm.myaop;

public class AopInterceptor {
    public static void before(){
        System.out.println(".......before().......");
    }

    public static void after(){
        System.out.println(".......after().......");
    }
}
