package me.mingshan.bytecode.parse.type;

import me.mingshan.bytecode.parse.util.AccessFlagConstant;

/**
 * 访问标志枚举
 *
 * @author hanjuntao
 * @date 2021/8/12
 */
public enum AccessFlagEnum {
    ACC_PUBLIC(AccessFlagConstant.ACC_PUBLIC, AccessFlagConstant.ACC_PUBLIC_DESC),
    ACC_FINAL(AccessFlagConstant.ACC_FINAL, AccessFlagConstant.ACC_FINAL_DESC),
    ACC_SUPER(AccessFlagConstant.ACC_SUPER, AccessFlagConstant.ACC_SUPER_DESC),
    ACC_INTERFACE(AccessFlagConstant.ACC_INTERFACE, AccessFlagConstant.ACC_INTERFACE_DESC),
    ACC_ABSTRACT(AccessFlagConstant.ACC_ABSTRACT, AccessFlagConstant.ACC_ABSTRACT_DESC),
    ACC_SYNTHETIC(AccessFlagConstant.ACC_SYNTHETIC, AccessFlagConstant.ACC_SYNTHETIC_DESC),
    ACC_ANNOTATION(AccessFlagConstant.ACC_ANNOTATION, AccessFlagConstant.ACC_ANNOTATION_DESC),
    ACC_ENUM(AccessFlagConstant.ACC_ENUM, AccessFlagConstant.ACC_ENUM_DESC),

    ;

    private final int accessFlag;
    private final String desc;

    AccessFlagEnum(int accessFlag, String desc) {
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
