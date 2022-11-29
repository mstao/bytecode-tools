package me.mingshan.bytecode.parse.type;

/**
 * 字节表示
 */
public abstract class U {
    // 内部存储数组
    protected byte[] value;

    /**
     * 转为整形
     *
     * @return 整形
     */
    public abstract Integer toInteger();

    /**
     * 转为十六进制
     *
     * @return 十六进制表示
     */
    public String toHexString() {
        if (value == null || value.length <= 0) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Byte item : value) {
            int v = item & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }

        return "0x" + stringBuilder;
    }

    public byte[] getValue() {
        return value;
    }
}
