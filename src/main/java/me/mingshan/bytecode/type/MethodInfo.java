package me.mingshan.bytecode.type;

import me.mingshan.bytecode.util.AccessFlagsUtil;
import me.mingshan.bytecode.util.ConstantPoolUtil;

import java.util.Arrays;

/**
 * 方法明细
 */
public class MethodInfo {
    private U2 accessFlags;
    private U2 nameIndex;
    private U2 descriptorIndex;
    private U2 attributesCount;
    private AttributeInfo[] attributes;

    public U2 getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(U2 accessFlags) {
        this.accessFlags = accessFlags;
    }

    public U2 getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(U2 nameIndex) {
        this.nameIndex = nameIndex;
    }

    public U2 getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(U2 descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public U2 getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(U2 attributesCount) {
        this.attributesCount = attributesCount;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }

    public void setAttributes(AttributeInfo[] attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "MethodInfo{" +
                "accessFlags=" + accessFlags.toHexString() +
                ", nameIndex=" + nameIndex.toInteger() +
                ", descriptorIndex=" + descriptorIndex.toInteger() +
                ", attributesCount=" + attributesCount.toInteger() +
                ", attributes=" + Arrays.toString(attributes) +
                '}';
    }

    public String detail(ClassFile classFile) {
        return "MethodInfo{" +
                "accessFlags= [" + AccessFlagsUtil.parseFieldAccessFlag(accessFlags.toInteger()) + "] " +
                ", nameIndex=" + ConstantPoolUtil.getByIndex(classFile, nameIndex.toInteger() - 1) +
                ", descriptorIndex=" + ConstantPoolUtil.getByIndex(classFile, descriptorIndex.toInteger() - 1) +
                ", attributesCount=" + attributesCount.toInteger() +
                ", attributes=" + Arrays.toString(attributes) +
                '}';
    }
}
