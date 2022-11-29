package me.mingshan.bytecode.parse.type.constantpool;

import me.mingshan.bytecode.parse.type.CpInfo;
import me.mingshan.bytecode.parse.type.U2;

import java.nio.ByteBuffer;

public class CONSTANT_MethodType_info extends CpInfo {
    private U2 descriptorIndex;

    public CONSTANT_MethodType_info(CpInfoTagEnum tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuffer) {
        descriptorIndex = new U2(codeBuffer.get(), codeBuffer.get());
    }

    @Override
    public String toString() {
        return "CONSTANT_MethodType_info{" +
                "tag=" + super.getTag().getValue() +
                ", descriptorIndex=" + descriptorIndex.toInteger() +
                '}';
    }

    public U2 getDescriptorIndex() {
        return descriptorIndex;
    }
}
