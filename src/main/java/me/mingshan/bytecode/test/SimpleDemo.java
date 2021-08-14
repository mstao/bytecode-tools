package me.mingshan.bytecode.test;

public class SimpleDemo {
    public static final String TEST = "ZZ";
    public static final int TEST2 = 1;
    public static final float TEST3 = 2.0F;
    public static final double TEST4 = 3.0;
    public static final long TEST5 = 4L;

    private String name;

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
