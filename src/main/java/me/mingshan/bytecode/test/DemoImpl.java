package me.mingshan.bytecode.test;

public class DemoImpl implements Demo {
    public static final String TEST = "ZZ";
    public static final int TEST2 = 1;
    public static final float TEST3 = 2.0F;
    public static final double TEST4 = 3.0;
    public static final long TEST5 = 4L;

    private String name;

    public DemoImpl(String name) {
        this.name = name;
    }

    @Override
    public void sayHello() {
        String s = " hello";
        System.out.println(name + s);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("run");
    }
}
