package me.mingshan.bytecode.type.attribute;

import me.mingshan.bytecode.type.ClassFile;
import me.mingshan.bytecode.type.U2;
import me.mingshan.bytecode.type.U4;
import me.mingshan.bytecode.util.ConstantPoolUtil;

/**
 * @author hanjuntao
 * @date 2021/8/14
 */
public class ConstantValueAttribute extends BaseAttribute {
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

    public ConstantValueAttribute(U2 attributeNameIndex, U4 attributeLength) {
        super(attributeNameIndex, attributeLength);
    }

    @Override
    public AttributeType getType() {
        return AttributeType.ConstantValue;
    }

    public U2 getConstantValueIndex() {
        return constantValueIndex;
    }

    public void setConstantValueIndex(U2 constantValueIndex) {
        this.constantValueIndex = constantValueIndex;
    }

    @Override
    public String toString() {
        return "ConstantValueAttribute{"
                + super.toString() +
                ", constantValueIndex=" + constantValueIndex.toInteger() +
                '}';
    }

    public String detail(ClassFile classFile) {

        return "ConstantValueAttribute{"
                + super.detail(classFile) +
                ", constantValueIndex=" + ConstantPoolUtil.getByIndex(classFile, constantValueIndex.toInteger() - 1) +
                '}';
    }
}
