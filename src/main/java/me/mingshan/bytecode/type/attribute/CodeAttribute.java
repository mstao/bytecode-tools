package me.mingshan.bytecode.type.attribute;

import me.mingshan.bytecode.type.AttributeInfo;
import me.mingshan.bytecode.type.U1;
import me.mingshan.bytecode.type.U2;
import me.mingshan.bytecode.type.U4;

/**
 * @author hanjuntao
 * @date 2021/8/14
 */
public class CodeAttribute {
    private U2 attributeNameIndex;
    private U4 attributeLength;
    private U2 maxStack;
    private U2 maxLocals;
    private U4 codeLength;
    private U1[] code;
    private U2 exceptionTableLength;
    private ExceptionTable[] exception_table;
    private U2 attributesCount;
    private AttributeInfo attributes;
}
