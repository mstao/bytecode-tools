package me.mingshan.bytecode.type.constantpool;

import me.mingshan.bytecode.type.CpInfo;
import me.mingshan.bytecode.type.U4;

import java.nio.ByteBuffer;

public class CONSTANT_Integer_info extends CpInfo {
    private U4 bytes;

    public CONSTANT_Integer_info(CpInfoTagEnum tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuffer) {
        bytes = new U4(codeBuffer.get(), codeBuffer.get(), codeBuffer.get(), codeBuffer.get());
    }

    @Override
    public String toString() {
        return "CONSTANT_Integer_info{" +
                "tag=" + super.getTag().getValue() +
                ", bytes=" + bytes.toHexString() +
                '}';
    }

    public U4 getBytes() {
        return bytes;
    }

}
