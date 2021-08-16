package me.mingshan.bytecode.type.attribute;

import me.mingshan.bytecode.type.ClassFile;
import me.mingshan.bytecode.type.U2;
import me.mingshan.bytecode.type.U4;
import me.mingshan.bytecode.type.constantpool.CONSTANT_Utf8_info;
import me.mingshan.bytecode.util.ConstantPoolUtil;

/**
 * 基础
 *
 * @author hanjuntao
 * @date 2021/8/16
 */
public abstract class BaseAttribute {
    private U2 attributeNameIndex;
    private U4 attributeLength;

    public BaseAttribute(U2 attributeNameIndex, U4 attributeLength) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
    }

    public abstract AttributeType getType();

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

    @Override
    public String toString() {
        return "BaseAttribute{" +
                "attributeNameIndex=" + attributeNameIndex +
                ", attributeLength=" + attributeLength +
                '}';
    }

    public String detail(ClassFile classFile) {
        CONSTANT_Utf8_info nameInfo = (CONSTANT_Utf8_info) ConstantPoolUtil.getByIndex(classFile, attributeNameIndex.toInteger() - 1);
        String name = nameInfo.detail();

        return "attributeName=" + name +
                ", attributeLength=" + attributeLength.toInteger();
    }
}
