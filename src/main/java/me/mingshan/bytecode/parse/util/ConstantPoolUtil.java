package me.mingshan.bytecode.parse.util;

import me.mingshan.bytecode.parse.type.constantpool.CONSTANT_Class_info;
import me.mingshan.bytecode.parse.type.constantpool.CONSTANT_Utf8_info;
import me.mingshan.bytecode.parse.type.ClassFile;
import me.mingshan.bytecode.parse.type.CpInfo;

import java.util.Objects;

/**
 * @author hanjuntao
 * @date 2021/8/13
 */
public class ConstantPoolUtil {

    public static CONSTANT_Utf8_info getUtf8InfoByClassInfo(ClassFile classFile, int index) {
        Objects.requireNonNull(classFile, "classFile");
        CpInfo[] constantPool = classFile.getConstantPool();

        if (constantPool != null && constantPool.length > 0) {
            CONSTANT_Class_info cpInfo = (CONSTANT_Class_info) constantPool[index - 1];

            return (CONSTANT_Utf8_info) getByIndex(classFile, cpInfo.getNameIndex().toInteger() - 1);
        }

        return null;
    }

    public static CpInfo getByIndex(ClassFile classFile, int index) {
        Objects.requireNonNull(classFile, "classFile");
        CpInfo[] constantPool = classFile.getConstantPool();

        if (constantPool != null && index >= 0 && index < constantPool.length) {
            return constantPool[index];
        }

        return null;
    }
}
