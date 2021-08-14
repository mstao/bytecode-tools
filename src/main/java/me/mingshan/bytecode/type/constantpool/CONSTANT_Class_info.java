package me.mingshan.bytecode.type.constantpool;

import me.mingshan.bytecode.type.CpInfo;
import me.mingshan.bytecode.type.U2;

import java.nio.ByteBuffer;

public class CONSTANT_Class_info extends CpInfo {
    private U2 nameIndex;

    public CONSTANT_Class_info(CpInfoTagEnum tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuffer) {
        nameIndex = new U2(codeBuffer.get(), codeBuffer.get());
    }

    @Override
    public String toString() {
        return " CONSTANT_Class_info{" +
                "tag=" + super.getTag().getValue() +
                ", nameIndex=" + nameIndex.toInteger() +
                '}';
    }

    public U2 getNameIndex() {
        return nameIndex;
    }
}
