package me.mingshan.bytecode.type.attribute;

import me.mingshan.bytecode.type.AttributeInfo;
import me.mingshan.bytecode.type.U1;
import me.mingshan.bytecode.type.U2;
import me.mingshan.bytecode.type.U4;

import java.util.Arrays;

/**
 * @author hanjuntao
 * @date 2021/8/14
 */
public class CodeAttribute extends BaseAttribute {
    private U2 maxStack;
    private U2 maxLocals;
    private U4 codeLength;
    private U1[] code;
    private U2 exceptionTableLength;
    private ExceptionTable[] exception_table;
    private U2 attributesCount;
    private AttributeInfo attributes;

    public CodeAttribute(U2 attributeNameIndex, U4 attributeLength) {
        super(attributeNameIndex, attributeLength);
    }

    @Override
    public AttributeType getType() {
        return AttributeType.Code;
    }

    public U2 getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(U2 maxStack) {
        this.maxStack = maxStack;
    }

    public U2 getMaxLocals() {
        return maxLocals;
    }

    public void setMaxLocals(U2 maxLocals) {
        this.maxLocals = maxLocals;
    }

    public U4 getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(U4 codeLength) {
        this.codeLength = codeLength;
    }

    public U1[] getCode() {
        return code;
    }

    public void setCode(U1[] code) {
        this.code = code;
    }

    public U2 getExceptionTableLength() {
        return exceptionTableLength;
    }

    public void setExceptionTableLength(U2 exceptionTableLength) {
        this.exceptionTableLength = exceptionTableLength;
    }

    public ExceptionTable[] getException_table() {
        return exception_table;
    }

    public void setException_table(ExceptionTable[] exception_table) {
        this.exception_table = exception_table;
    }

    public U2 getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(U2 attributesCount) {
        this.attributesCount = attributesCount;
    }

    public AttributeInfo getAttributes() {
        return attributes;
    }

    public void setAttributes(AttributeInfo attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "CodeAttribute{" +
                "maxStack=" + maxStack +
                ", maxLocals=" + maxLocals +
                ", codeLength=" + codeLength +
                ", code=" + Arrays.toString(code) +
                ", exceptionTableLength=" + exceptionTableLength +
                ", exception_table=" + Arrays.toString(exception_table) +
                ", attributesCount=" + attributesCount +
                ", attributes=" + attributes +
                '}';
    }
}
