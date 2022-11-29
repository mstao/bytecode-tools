package me.mingshan.bytecode.parse.handler.attribute;

import me.mingshan.bytecode.parse.type.AttributeInfo;
import me.mingshan.bytecode.parse.type.ClassFile;
import me.mingshan.bytecode.parse.type.attribute.AttributeType;
import me.mingshan.bytecode.parse.type.attribute.BaseAttribute;

/**
 * @author hanjuntao
 * @date 2021/8/16
 */
public interface BaseAttributeHandler {

    BaseAttribute processAttribute(ClassFile classFile, AttributeInfo attributeInfo);

    AttributeType getType();
}
