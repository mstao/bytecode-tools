package me.mingshan.bytecode.parse.type;

import me.mingshan.bytecode.parse.util.AccessFlagsUtil;
import me.mingshan.bytecode.parse.util.ConstantPoolUtil;

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
        StringBuilder attributeBuild = new StringBuilder();
        if (attributes != null && attributes.length > 0) {
            for (AttributeInfo attributeInfo : attributes) {
                attributeBuild.append(attributeInfo.detail(classFile));
            }
        }

        return "MethodInfo{" +
                "accessFlags= [" + AccessFlagsUtil.parseMethodAccessFlag(accessFlags.toInteger()) + "] " +
                ", nameIndex=" + ConstantPoolUtil.getByIndex(classFile, nameIndex.toInteger() - 1) +
                ", descriptorIndex=" + ConstantPoolUtil.getByIndex(classFile, descriptorIndex.toInteger() - 1) +
                ", attributesCount=" + attributesCount.toInteger() +
                ", attributes=" + attributeBuild.toString() +
                '}';
    }
}
