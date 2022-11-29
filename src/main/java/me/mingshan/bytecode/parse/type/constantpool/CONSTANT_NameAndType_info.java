package me.mingshan.bytecode.parse.type.constantpool;

import me.mingshan.bytecode.parse.type.CpInfo;
import me.mingshan.bytecode.parse.type.U2;

import java.nio.ByteBuffer;

public class CONSTANT_NameAndType_info extends CpInfo {
    private U2 nameIndex;
    private U2 descriptorIndex;

    public CONSTANT_NameAndType_info(CpInfoTagEnum tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuffer) {
        nameIndex = new U2(codeBuffer.get(), codeBuffer.get());
        descriptorIndex = new U2(codeBuffer.get(), codeBuffer.get());
    }

    @Override
    public String toString() {
        return "CONSTANT_NameAndType_info{" +
                "tag=" + super.getTag().getValue() +
                ", nameIndex=" + nameIndex.toInteger() +
                ", descriptorIndex=" + descriptorIndex.toInteger() +
                '}';
    }

    public U2 getNameIndex() {
        return nameIndex;
    }

    public U2 getDescriptorIndex() {
        return descriptorIndex;
    }
}
