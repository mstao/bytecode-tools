package me.mingshan.bytecode.parse.type;

import me.mingshan.bytecode.parse.util.AccessFlagConstant;

/**
 * 字段访问标志
 *
 * @author hanjuntao
 * @date 2021/8/13
 */
public enum FieldAccessFlagEnum {
    ACC_PUBLIC(AccessFlagConstant.ACC_PUBLIC, AccessFlagConstant.ACC_PUBLIC_DESC),
    ACC_PRIVATE(AccessFlagConstant.ACC_PRIVATE, AccessFlagConstant.ACC_PRIVATE_DESC),
    ACC_PROTECTED(AccessFlagConstant.ACC_PROTECTED, AccessFlagConstant.ACC_PROTECTED_DESC),
    ACC_STATIC(AccessFlagConstant.ACC_STATIC, AccessFlagConstant.ACC_STATIC_DESC),
    ACC_FINAL(AccessFlagConstant.ACC_FINAL, AccessFlagConstant.ACC_FINAL_DESC),
    ACC_VOLATILE(AccessFlagConstant.ACC_VOLATILE, AccessFlagConstant.ACC_VOLATILE_DESC),
    ACC_TRANSIENT(AccessFlagConstant.ACC_TRANSIENT, AccessFlagConstant.ACC_TRANSIENT_DESC),
    ACC_SYNTHETIC(AccessFlagConstant.ACC_SYNTHETIC, AccessFlagConstant.ACC_SYNTHETIC_DESC),
    ACC_ENUM(AccessFlagConstant.ACC_ENUM, AccessFlagConstant.ACC_ENUM_DESC),

    ;

    private final int accessFlag;
    private final String desc;

    FieldAccessFlagEnum(int accessFlag, String desc) {
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
