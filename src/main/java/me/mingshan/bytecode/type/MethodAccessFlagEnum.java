package me.mingshan.bytecode.type;

import me.mingshan.bytecode.util.AccessFlagConstant;

/**
 * @author hanjuntao
 * @date 2021/8/14
 */
public enum MethodAccessFlagEnum {
    ACC_PUBLIC(AccessFlagConstant.ACC_PUBLIC, AccessFlagConstant.ACC_PUBLIC_DESC),
    ACC_PRIVATE(AccessFlagConstant.ACC_PRIVATE, AccessFlagConstant.ACC_PRIVATE_DESC),
    ACC_PROTECTED(AccessFlagConstant.ACC_PROTECTED, AccessFlagConstant.ACC_PROTECTED_DESC),
    ACC_STATIC(AccessFlagConstant.ACC_STATIC, AccessFlagConstant.ACC_STATIC_DESC),
    ACC_FINAL(AccessFlagConstant.ACC_FINAL, AccessFlagConstant.ACC_FINAL_DESC),
    ACC_SYNCHRONIZED(AccessFlagConstant.ACC_SYNCHRONIZED, AccessFlagConstant.ACC_SYNCHRONIZED_DESC),
    ACC_BRIDGE(AccessFlagConstant.ACC_BRIDGE, AccessFlagConstant.ACC_BRIDGE_DESC),
    ACC_VARARGS(AccessFlagConstant.ACC_VARARGS, AccessFlagConstant.ACC_VARARGS_DESC),
    ACC_NATIVE(AccessFlagConstant.ACC_NATIVE, AccessFlagConstant.ACC_NATIVE_DESC),
    ACC_ABSTRACT(AccessFlagConstant.ACC_ABSTRACT, AccessFlagConstant.ACC_ABSTRACT_DESC),
    ACC_STRICT(AccessFlagConstant.ACC_STRICT, AccessFlagConstant.ACC_STRICT_DESC),
    ACC_SYNTHETIC(AccessFlagConstant.ACC_SYNTHETIC, AccessFlagConstant.ACC_SYNTHETIC_DESC),

   ;

    private final int accessFlag;
    private final String desc;

    MethodAccessFlagEnum(int accessFlag, String desc) {
        this.accessFlag = accessFlag;
        this.desc = desc;
    }

    public int getAccessFlag() {
        return accessFlag;
    }

    public String getDesc() {
        return desc;
    }
}
