package me.mingshan.bytecode.type.constantpool;

import me.mingshan.bytecode.type.CpInfo;
import me.mingshan.bytecode.type.U2;

import java.nio.ByteBuffer;

public class CONSTANT_InvokeDynamic_info extends CpInfo {
    private U2 bootstrapMethodAttrIndex;
    private U2 nameAndTypeIndex;

    public CONSTANT_InvokeDynamic_info(CpInfoTagEnum tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuffer) {
        bootstrapMethodAttrIndex = new U2(codeBuffer.get(), codeBuffer.get());
        nameAndTypeIndex = new U2(codeBuffer.get(), codeBuffer.get());
    }

    @Override
    public String toString() {
        return "CONSTANT_InvokeDynamic_info{" +
                "tag=" + super.getTag().getValue() +
                ", bootstrapMethodAttrIndex=" + bootstrapMethodAttrIndex.toHexString() +
                ", nameAndTypeIndex=" + nameAndTypeIndex.toHexString() +
                '}';
    }

    public U2 getBootstrapMethodAttrIndex() {
        return bootstrapMethodAttrIndex;
    }

    public U2 getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }
}
