package me.mingshan.bytecode.parse.handler.attribute;

import me.mingshan.bytecode.parse.type.AttributeInfo;
import me.mingshan.bytecode.parse.type.ClassFile;
import me.mingshan.bytecode.parse.type.U2;
import me.mingshan.bytecode.parse.type.attribute.AttributeType;
import me.mingshan.bytecode.parse.type.attribute.BaseAttribute;
import me.mingshan.bytecode.parse.type.attribute.ConstantValueAttribute;

/**
 * @author hanjuntao
 * @date 2021/8/16
 */
public class ConstantValueAttributeHandler implements BaseAttributeHandler {
    @Override
    public BaseAttribute processAttribute(ClassFile classFile, AttributeInfo attributeInfo) {
        ConstantValueAttribute attribute = new ConstantValueAttribute(attributeInfo.getAttributeNameIndex(),
                attributeInfo.getAttributeLength());
        attribute.setConstantValueIndex(new U2(attributeInfo.getInfo()[0], attributeInfo.getInfo()[1]));
        return attribute;
    }

    @Override
    public AttributeType getType() {
        return AttributeType.ConstantValue;
    }
}
