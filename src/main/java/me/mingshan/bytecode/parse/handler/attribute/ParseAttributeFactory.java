package me.mingshan.bytecode.parse.handler.attribute;

import me.mingshan.bytecode.parse.type.AttributeInfo;
import me.mingshan.bytecode.parse.type.ClassFile;
import me.mingshan.bytecode.parse.type.U2;
import me.mingshan.bytecode.parse.type.attribute.AttributeType;
import me.mingshan.bytecode.parse.type.attribute.BaseAttribute;
import me.mingshan.bytecode.parse.type.constantpool.CONSTANT_Utf8_info;
import me.mingshan.bytecode.parse.util.ConstantPoolUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hanjuntao
 * @date 2021/8/14
 */
public class ParseAttributeFactory {
    private static final Map<String, BaseAttributeHandler> ATTRIBUTE_HANDLER_MAP = new HashMap<>();

    static {
        ATTRIBUTE_HANDLER_MAP.put(AttributeType.ConstantValue.name(), new ConstantValueAttributeHandler());
        ATTRIBUTE_HANDLER_MAP.put(AttributeType.Code.name(), new CodeAttributeHandler());
    }

    public static BaseAttribute parseAttribute(ClassFile classFile, AttributeInfo attributeInfo) {
        U2 nameIndex = attributeInfo.getAttributeNameIndex();
        CONSTANT_Utf8_info nameInfo = (CONSTANT_Utf8_info) ConstantPoolUtil.getByIndex(classFile, nameIndex.toInteger() - 1);
        String name = nameInfo.detail();
        System.out.println("属性名称：" + name);

        BaseAttributeHandler attributeHandler = ATTRIBUTE_HANDLER_MAP.get(name);
        if (attributeHandler == null) {
            return null;
        }
        if (AttributeType.ConstantValue.equals(attributeHandler.getType())) {
            ConstantValueAttributeHandler constantValueAttributeHandler = (ConstantValueAttributeHandler) attributeHandler;
            return constantValueAttributeHandler.processAttribute(classFile, attributeInfo);
        }

        if (AttributeType.Code.equals(attributeHandler.getType())) {
            CodeAttributeHandler codeAttributeHandler = (CodeAttributeHandler) attributeHandler;
            return codeAttributeHandler.processAttribute(classFile, attributeInfo);
        }

        return null;
    }

}
