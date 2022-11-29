package me.mingshan.bytecode.parse.type;

/**
 * 两字节表示
 */
public class U2 extends U {

    public U2(byte v1, byte v2) {
        value = new byte[]{v1, v2};
    }

    public Integer toInteger() {
        return (value[0] & 0xff) << 8 | (value[1] & 0xff);
    }

}
