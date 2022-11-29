package me.mingshan.bytecode.parse.type;

import me.mingshan.bytecode.parse.util.AccessFlagsUtil;
import me.mingshan.bytecode.parse.util.ConstantPoolUtil;

import java.util.Arrays;

/**
 * 字段明细
 */
public class FieldInfo {
    // 访问级别
    private U2 accessFlags;
    // 名称索引，指向 CONSTANT_Utf8_info
    private U2 nameIndex;
    // 描述符索引，指向 CONSTANT_Utf8_info
    private U2 descriptorIndex;
    // 属性数量
    private U2 attributesCount;
    // 属性表
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
        return "FieldInfo{" +
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

        return "FieldInfo{" +
                "accessFlags= [" + AccessFlagsUtil.parseFieldAccessFlag(accessFlags.toInteger()) + "] " +
                ", nameIndex=" + ConstantPoolUtil.getByIndex(classFile, nameIndex.toInteger() - 1) +
                ", descriptorIndex=" + ConstantPoolUtil.getByIndex(classFile, descriptorIndex.toInteger() - 1) +
                ", attributesCount=" + attributesCount.toInteger() +
                ", attributes=" + attributeBuild +
                '}';
    }
}
