package me.mingshan.bytecode.parse.type.constantpool;

import me.mingshan.bytecode.parse.type.CpInfo;
import me.mingshan.bytecode.parse.type.U4;
import me.mingshan.bytecode.parse.util.Utils;

import java.nio.ByteBuffer;

public class CONSTANT_Long_info extends CpInfo {
    private U4 highBytes;
    private U4 lowBytes;

    public CONSTANT_Long_info(CpInfoTagEnum tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuffer) {
        highBytes = new U4(codeBuffer.get(), codeBuffer.get(), codeBuffer.get(), codeBuffer.get());
        lowBytes = new U4(codeBuffer.get(), codeBuffer.get(), codeBuffer.get(), codeBuffer.get());
    }

    @Override
    public String toString() {
        return "CONSTANT_Long_info{" +
                "tag=" + super.getTag().getValue() +
                ", highBytes=" + highBytes.toHexString() +
                ", lowBytes=" + lowBytes.toHexString() +
                ", value=" + Utils.combineInt2Long(lowBytes, highBytes) +
                '}';
    }

    public U4 getHighBytes() {
        return highBytes;
    }

    public U4 getLowBytes() {
        return lowBytes;
    }

}
