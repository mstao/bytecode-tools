package me.mingshan.bytecode.asm;

public class A1<T> {

    public A1() {
    }

    public A1(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
