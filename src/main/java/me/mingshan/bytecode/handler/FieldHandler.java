package me.mingshan.bytecode.handler;

import me.mingshan.bytecode.handler.attribute.AttributeProcessingFactory;
import me.mingshan.bytecode.type.*;
import me.mingshan.bytecode.util.AttributeUtil;

import java.nio.ByteBuffer;

/**
 * @author hanjuntao
 * @date 2021/8/13
 */
public class FieldHandler implements BaseHandler {
    @Override
    public int order() {
        return 7;
    }

    @Override
    public void read(ByteBuffer codeBuffer, ClassFile classFile) {
        System.out.println("解析顺序：" + order());
        System.out.println(">>>>>>> 字段解析开始 >>>>>>>");

        U2 fieldsCount = new U2(codeBuffer.get(), codeBuffer.get());
        classFile.setFieldsCount(fieldsCount);

        Integer fieldsCountInt = fieldsCount.toInteger();
        System.out.println("字段数量：" + fieldsCountInt);
        System.out.println("-----");

        if (fieldsCountInt > 0) {
            FieldInfo[] fieldInfos = new FieldInfo[fieldsCountInt];

            for (int i = 0; i < fieldsCountInt; i++) {
                FieldInfo fieldInfo = new FieldInfo();
                fieldInfo.setAccessFlags(new U2(codeBuffer.get(), codeBuffer.get()));
                fieldInfo.setNameIndex(new U2(codeBuffer.get(), codeBuffer.get()));
                fieldInfo.setDescriptorIndex(new U2(codeBuffer.get(), codeBuffer.get()));
                fieldInfo.setAttributesCount(new U2(codeBuffer.get(), codeBuffer.get()));

                Integer attributesCount = fieldInfo.getAttributesCount().toInteger();

                if (attributesCount != 0) {
                    AttributeInfo[] attributeInfos = AttributeUtil.parseAttributeInfos(codeBuffer, attributesCount);

                    for (AttributeInfo attributeInfo : attributeInfos) {
                        AttributeProcessingFactory.processConstantValueAttribute(classFile, attributeInfo);
                    }

                    fieldInfo.setAttributes(attributeInfos);
                }

                System.out.println("原始信息：" + fieldInfo);
                System.out.println("详细信息：" + fieldInfo.detail(classFile));
                System.out.println("-----");

                fieldInfos[i] = fieldInfo;
            }

            classFile.setFields(fieldInfos);
        }

        System.out.println("<<<<<<< 字段解析结束 <<<<<<<");
        System.out.println();
    }
}
