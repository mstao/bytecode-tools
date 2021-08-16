package me.mingshan.bytecode.type.constantpool;

import me.mingshan.bytecode.type.CpInfo;
import me.mingshan.bytecode.type.U2;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author hanjuntao
 * @date 2021/8/10
 */
public class CONSTANT_Utf8_info extends CpInfo {
    private U2 length;
    private byte[] bytes;

    public CONSTANT_Utf8_info(CpInfoTagEnum tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuffer) {
        length = new U2(codeBuffer.get(), codeBuffer.get());
        Integer intLength = length.toInteger();
        bytes = new byte[intLength];

        codeBuffer.get(bytes, 0, intLength);
    }

    public U2 getLength() {
        return length;
    }

    public byte[] getBytes() {
        return bytes;
    }

    @Override
    public String toString() {
        return "CONSTANT_Utf8_info{" +
                "tag=" + super.getTag().getValue() +
                ", length=" + length.toInteger() +
                ", bytes=" + new String(bytes, StandardCharsets.UTF_8) +
                '}';
    }

    public String detail() {
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
