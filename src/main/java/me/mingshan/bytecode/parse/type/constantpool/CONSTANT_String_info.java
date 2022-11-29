package me.mingshan.bytecode.parse.type.constantpool;

import me.mingshan.bytecode.parse.type.CpInfo;
import me.mingshan.bytecode.parse.type.U2;

import java.nio.ByteBuffer;

public class CONSTANT_String_info extends CpInfo {
    private U2 stringIndex;

    public CONSTANT_String_info(CpInfoTagEnum tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuffer) {
        stringIndex = new U2(codeBuffer.get(), codeBuffer.get());
    }

    @Override
    public String toString() {
        return "CONSTANT_String_info{" +
                "tag=" + super.getTag().getValue() +
                ", stringIndex=" + stringIndex.toInteger() +
                '}';
    }

    public U2 getStringIndex() {
        return stringIndex;
    }
}
