package me.mingshan.bytecode.handler.attribute;

import me.mingshan.bytecode.type.AttributeInfo;
import me.mingshan.bytecode.type.ClassFile;
import me.mingshan.bytecode.type.U;
import me.mingshan.bytecode.type.U2;
import me.mingshan.bytecode.type.attribute.ConstantValueAttribute;
import me.mingshan.bytecode.type.constantpool.CONSTANT_Utf8_info;
import me.mingshan.bytecode.util.ConstantPoolUtil;

/**
 * @author hanjuntao
 * @date 2021/8/14
 */
public class AttributeProcessingFactory {

    public static ConstantValueAttribute processConstantValueAttribute(ClassFile classFile, AttributeInfo attributeInfo) {
        U2 nameIndex = attributeInfo.getAttributeNameIndex();
        CONSTANT_Utf8_info nameInfo = (CONSTANT_Utf8_info) ConstantPoolUtil.getByIndex(classFile, nameIndex.toInteger() - 1);
        String name = nameInfo.detail();
        System.out.println(name);

//        ConstantValueAttribute attribute = new ConstantValueAttribute();
//        attribute.setAttributeNameIndex(nameIndex);
//        attribute.setAttributeLength(attributeInfo.getAttributeLength());
//        attribute.setConstantValueIndex(new U2(attributeInfo.getInfo()[0], attributeInfo.getInfo()[1]));

        return null;
    }

}
