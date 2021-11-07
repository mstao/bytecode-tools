package me.mingshan.bytecode.asm;

/**
 * @author hanjuntao
 * @date 2021/10/29
 */
public class A {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void f() {
        int z = 1;

        System.out.println(z++ + ++z);
    }

    public static void f2() {
        int z = 1;
        z = z + 1;
        ++z;
        System.out.println(z + z);
    }

    public static void main(String[] args) {
        f();
        f2();
    }
}
