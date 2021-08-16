package me.mingshan.bytecode.type.attribute;

/**
 * @author hanjuntao
 * @date 2021/8/16
 */
public enum AttributeType {
    ConstantValue("常量值"),
    Code("字节码指令")
    ;

    private final String desc;

    AttributeType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
