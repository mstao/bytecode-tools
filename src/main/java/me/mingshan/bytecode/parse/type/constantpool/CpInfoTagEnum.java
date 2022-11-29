package me.mingshan.bytecode.parse.type.constantpool;

public enum CpInfoTagEnum {
    CONSTANT_Class((byte) 7),
    CONSTANT_Fieldref((byte) 9),
    CONSTANT_Methodref((byte) 10),
    CONSTANT_InterfaceMethodref((byte) 11),
    CONSTANT_String((byte) 8),
    CONSTANT_Integer((byte) 3),
    CONSTANT_Float((byte) 4),
    CONSTANT_Long((byte) 5),
    CONSTANT_Double((byte) 6),
    CONSTANT_NameAndType((byte) 12),
    CONSTANT_Utf8((byte) 1),
    CONSTANT_MethodHandle((byte) 15),
    CONSTANT_MethodType((byte) 16),
    CONSTANT_InvokeDynamic((byte) 18),
    CONSTANT_Module((byte) 19), // jdk9
    CONSTANT_Package((byte) 20), // jdk9
    ;

    private final byte value;

    CpInfoTagEnum(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }
    
    public static CpInfoTagEnum valueOf2(byte code) {
        CpInfoTagEnum[] values = values();

        for (CpInfoTagEnum cpInfoTagEnum : values) {
            if (cpInfoTagEnum.getValue() == code) {
                return cpInfoTagEnum;
            }
        }

        throw new IllegalArgumentException("根据：" + code + "找不到CpInfoTag");
    }
}
