package me.mingshan.bytecode.handler.attribute;

import me.mingshan.bytecode.type.AttributeInfo;
import me.mingshan.bytecode.type.ClassFile;
import me.mingshan.bytecode.type.attribute.AttributeType;
import me.mingshan.bytecode.type.attribute.BaseAttribute;

/**
 * @author hanjuntao
 * @date 2021/8/16
 */
public interface BaseAttributeHandler {

    BaseAttribute processAttribute(ClassFile classFile, AttributeInfo attributeInfo);

    AttributeType getType();
}
