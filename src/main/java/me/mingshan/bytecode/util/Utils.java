package me.mingshan.bytecode.util;

import me.mingshan.bytecode.type.U4;

public class Utils {
    public static long combineInt2Long(int low, int high) {
        return ((long) low & 0xFFFFFFFFL) | (((long) high << 32) & 0xFFFFFFFF00000000L);
    }

    public static long combineInt2Long(U4 low, U4 high) {
        return combineInt2Long(low.toInteger(), high.toInteger());
    }

    public static double combineInt2Double(U4 low, U4 high) {
        return combineInt2Long(low.toInteger(), high.toInteger());
    }

    /**
     * byte数组中取int数值，本方法适用于(低位在前，高位在后)的顺序。
     *
     * @param ary    byte数组
     * @param offset 从数组的第offset位开始
     * @return int数值
     */
    public static int bytesToInt(byte[] ary, int offset) {
        int value;
        value = (ary[offset] & 0xFF)
                | ((ary[offset + 1] << 8) & 0xFF00)
                | ((ary[offset + 2] << 16) & 0xFF0000)
                | ((ary[offset + 3] << 24) & 0xFF000000);
        return value;
    }

    /**
     * 将int数值转换为占四个字节的byte数组，本方法适用于(低位在前，高位在后)的顺序。
     *
     * @param value 要转换的int值
     * @return byte数组
     */
    public static byte[] intToBytes(int value) {
        byte[] byteSrc = new byte[4];
        byteSrc[3] = (byte) ((value & 0xFF000000) >> 24);
        byteSrc[2] = (byte) ((value & 0x00FF0000) >> 16);
        byteSrc[1] = (byte) ((value & 0x0000FF00) >> 8);
        byteSrc[0] = (byte) ((value & 0x000000FF));
        return byteSrc;
    }

    public static String toFirstUpperCase(String source) {
        char[] chars = source.toCharArray();
        if (chars[0] >= 'a' && chars[0] <= 'z') {
            chars[0] = (char) (chars[0] - 32);
        }

        return new String(chars);
    }
}
