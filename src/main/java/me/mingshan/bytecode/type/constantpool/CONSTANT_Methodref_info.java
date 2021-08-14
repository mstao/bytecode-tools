package me.mingshan.bytecode.type.constantpool;

import me.mingshan.bytecode.type.CpInfo;
import me.mingshan.bytecode.type.U2;

import java.nio.ByteBuffer;

public class CONSTANT_Methodref_info extends CpInfo {
    private U2 classIndex;
    private U2 nameAndTypeIndex;

    public CONSTANT_Methodref_info(CpInfoTagEnum tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuffer) {
        classIndex = new U2(codeBuffer.get(), codeBuffer.get());
        nameAndTypeIndex = new U2(codeBuffer.get(), codeBuffer.get());
    }

    @Override
    public String toString() {
        return " CONSTANT_Methodref_info{" +
                "tag=" + super.getTag().getValue() +
                ", classIndex=" + classIndex.toInteger() +
                ", nameAndTypeIndex=" + nameAndTypeIndex.toInteger() +
                '}';
    }

    public U2 getClassIndex() {
        return classIndex;
    }

    public U2 getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }
}