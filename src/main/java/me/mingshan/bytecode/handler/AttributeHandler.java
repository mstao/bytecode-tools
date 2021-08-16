package me.mingshan.bytecode.handler;

import me.mingshan.bytecode.type.AttributeInfo;
import me.mingshan.bytecode.type.ClassFile;
import me.mingshan.bytecode.type.U2;
import me.mingshan.bytecode.util.AttributeUtil;

import java.nio.ByteBuffer;

/**
 * @author hanjuntao
 * @date 2021/8/14
 */
public class AttributeHandler implements BaseHandler {
    @Override
    public int order() {
        return 9;
    }

    @Override
    public void read(ByteBuffer codeBuffer, ClassFile classFile) {
        System.out.println("解析顺序：" + order());
        System.out.println(">>>>>>> 属性解析开始 >>>>>>>");

        U2 attributesCount = new U2(codeBuffer.get(), codeBuffer.get());
        classFile.setAttributesCount(attributesCount);
        Integer attributesCountInt = attributesCount.toInteger();

        System.out.println("属性数量：" + attributesCountInt);

        AttributeInfo[] attributeInfos = AttributeUtil.parseAttributeInfos(codeBuffer, attributesCountInt);
        classFile.setAttributes(attributeInfos);

        if (attributesCountInt > 0) {
            for (AttributeInfo attributeInfo : attributeInfos) {
                System.out.println("-----");
                System.out.println("原始信息：" + attributeInfo);
                System.out.println("详细信息：" + attributeInfo.detail(classFile));
            }
        }

        System.out.println("<<<<<<< 属性解析结束 <<<<<<<");
        System.out.println();
    }
}
