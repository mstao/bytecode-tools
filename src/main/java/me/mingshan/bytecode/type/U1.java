package me.mingshan.bytecode.type;

/**
 * 一字节表示
 */
public class U1 extends U {
    public U1(byte v1) {
        value = new byte[]{v1};
    }

    @Override
    public Integer toInteger() {
        return value[0] & 0xff;
    }
}
