package me.mingshan.bytecode.parse.util;

/**
 * 访问标志常量
 *
 * @author hanjuntao
 * @date 2021/8/13
 */
public class AccessFlagConstant {

    /*
     * value
     */
    public static final int ACC_PUBLIC = 0x0001;
    public static final int ACC_PRIVATE = 0x0002;
    public static final int ACC_PROTECTED = 0x0004;
    public static final int ACC_STATIC = 0x0008;
    public static final int ACC_FINAL = 0x0010;
    public static final int ACC_SUPER = 0x0020;
    public static final int ACC_SYNCHRONIZED = 0x0020;
    public static final int ACC_VOLATILE = 0x0040;
    public static final int ACC_BRIDGE = 0x0040;
    public static final int ACC_TRANSIENT = 0x0080;
    public static final int ACC_VARARGS = 0x0080;
    public static final int ACC_NATIVE = 0x0100;
    public static final int ACC_INTERFACE = 0x0200;
    public static final int ACC_ABSTRACT = 0x0400;
    public static final int ACC_STRICT = 0x0800;
    public static final int ACC_SYNTHETIC = 0x1000;
    public static final int ACC_ANNOTATION = 0x2000;
    public static final int ACC_ENUM = 0x4000;


    /*
     * desc
     */

    public static final String ACC_PUBLIC_DESC = "public";
    public static final String ACC_PRIVATE_DESC = "private";
    public static final String ACC_PROTECTED_DESC = "protected";
    public static final String ACC_STATIC_DESC = "static";
    public static final String ACC_FINAL_DESC = "final";
    public static final String ACC_SUPER_DESC = "super";
    public static final String ACC_SYNCHRONIZED_DESC = "synchronized";
    public static final String ACC_VOLATILE_DESC = "volatile";
    public static final String ACC_BRIDGE_DESC = "bridge";
    public static final String ACC_TRANSIENT_DESC = "transient";
    public static final String ACC_VARARGS_DESC = "varargs";
    public static final String ACC_NATIVE_DESC = "native";
    public static final String ACC_INTERFACE_DESC = "interface";
    public static final String ACC_ABSTRACT_DESC = "abstract";
    public static final String ACC_STRICT_DESC = "strict";
    public static final String ACC_SYNTHETIC_DESC = "synthetic";
    public static final String ACC_ANNOTATION_DESC = "annotation";
    public static final String ACC_ENUM_DESC = "enum";
}
