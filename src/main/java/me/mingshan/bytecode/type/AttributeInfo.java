package me.mingshan.bytecode.type;

import me.mingshan.bytecode.util.ConstantPoolUtil;

import java.util.Arrays;

/**
 * 属性明细
 */
public class AttributeInfo {
    //  The constant_pool entry at attribute_name_index must be a CONSTANT_Utf8_info structure representing the name of the attribute.
    private U2 attributeNameIndex;
    private U4 attributeLength;
    private byte[] info;

    public U2 getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public void setAttributeNameIndex(U2 attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    public U4 getAttributeLength() {
        return attributeLength;
    }

    public void setAttributeLength(U4 attributeLength) {
        this.attributeLength = attributeLength;
    }

    public byte[] getInfo() {
        return info;
    }

    public void setInfo(byte[] info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "AttributeInfo{" +
                "attributeNameIndex=" + attributeNameIndex.toInteger() +
                ", attributeLength=" + attributeLength.toInteger() +
                ", info=" + Arrays.toString(info) +
                '}';
    }

    public String detail(ClassFile classFile) {
        return "AttributeInfo{" +
                "attributeNameIndex=" + ConstantPoolUtil.getByIndex(classFile,attributeNameIndex.toInteger() - 1) +
                ", attributeLength=" + attributeLength.toInteger() +
                ", info=" + Arrays.toString(info) +
                '}';
    }
}
