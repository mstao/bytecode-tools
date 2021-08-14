package me.mingshan.bytecode.type;

/**
 * 四字节表示
 */
public class U4 extends U {

    public U4(byte v1, byte v2, byte v3, byte v4) {
        value = new byte[]{v1, v2, v3, v4};
    }

    @Override
    public Integer toInteger() {
        int a = (value[0] & 0xff) << 24;
        a |= (value[1] & 0xff) << 16;
        a |= (value[2] & 0xff) << 8;

        return a | (value[3] & 0xff);
    }

}
