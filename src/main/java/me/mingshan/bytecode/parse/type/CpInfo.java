package me.mingshan.bytecode.parse.type;

import me.mingshan.bytecode.parse.type.constantpool.ConstantInfoHandler;
import me.mingshan.bytecode.parse.type.constantpool.CpInfoTagEnum;

/**
 * 常量池明细
 */
public abstract class CpInfo implements ConstantInfoHandler {
    private final CpInfoTagEnum tag;

    public CpInfo(CpInfoTagEnum tag) {
        this.tag = tag;
    }

    public CpInfoTagEnum getTag() {
        return tag;
    }
}
