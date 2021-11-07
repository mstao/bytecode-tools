package me.mingshan.bytecode.asm.myaop;

public class Test {
    public static void main(String[] args) {
        MyEnhancer myEnhancer = new MyEnhancer();
        myEnhancer.setSuperclass(Demo2.class);
        myEnhancer.setCallback(new AopInterceptor());
        Demo2 o = (Demo2)myEnhancer.create();
        o.say();
    }
}
