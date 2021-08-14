package me.mingshan.bytecode.type;

import java.util.Arrays;

/**
 * 属性明细
 */
public class AttributeInfo {
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
}
