package me.mingshan.bytecode.type.attribute;

import me.mingshan.bytecode.type.ClassFile;
import me.mingshan.bytecode.type.U2;
import me.mingshan.bytecode.type.U4;
import me.mingshan.bytecode.util.ConstantPoolUtil;

/**
 * @author hanjuntao
 * @date 2021/8/14
 */
public class ConstantValueAttribute {
    private U2 attributeNameIndex;
    private U4 attributeLength;
    /**
     * <pre>
     * Field Type	Entry Type
     * long	CONSTANT_Long
     * float	CONSTANT_Float
     * double	CONSTANT_Double
     * int, short, char, byte, boolean	CONSTANT_Integer
     * String	CONSTANT_String
     * </pre>
     */
    private U2 constantValueIndex;

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

    public U2 getConstantValueIndex() {
        return constantValueIndex;
    }

    public void setConstantValueIndex(U2 constantValueIndex) {
        this.constantValueIndex = constantValueIndex;
    }

    @Override
    public String toString() {
        return "ConstantValueAttribute{" +
                "attributeNameIndex=" + attributeNameIndex.toInteger() +
                ", attributeLength=" + attributeLength.toInteger() +
                ", constantValueIndex=" + constantValueIndex.toInteger() +
                '}';
    }

    public String detail(ClassFile classFile) {
        return "ConstantValueAttribute{" +
                "attributeNameIndex=" + ConstantPoolUtil.getByIndex(classFile, attributeLength.toInteger() - 1) +
                ", attributeLength=" + attributeLength.toInteger() +
                ", constantValueIndex=" + ConstantPoolUtil.getByIndex(classFile, constantValueIndex.toInteger() - 1) +
                '}';
    }
}
