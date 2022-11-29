package me.mingshan.bytecode.parse.type.constantpool;

import me.mingshan.bytecode.parse.type.CpInfo;
import me.mingshan.bytecode.parse.type.U1;
import me.mingshan.bytecode.parse.type.U2;

import java.nio.ByteBuffer;

public class CONSTANT_MethodHandle_info extends CpInfo {
    private U1 referenceKind;
    private U2 referenceIndex;

    public CONSTANT_MethodHandle_info(CpInfoTagEnum tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuffer) {
        referenceKind = new U1(codeBuffer.get());
        referenceIndex = new U2(codeBuffer.get(), codeBuffer.get());
    }

    @Override
    public String toString() {
        return "CONSTANT_MethodHandle_info{" +
                "tag=" + super.getTag().getValue() +
                ", referenceKind=" + referenceKind.toHexString() +
                ", referenceIndex=" + referenceIndex.toHexString() +
                '}';
    }
}
