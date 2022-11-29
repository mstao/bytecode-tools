package me.mingshan.bytecode.parse.handler;

import me.mingshan.bytecode.parse.type.*;
import me.mingshan.bytecode.parse.util.AttributeUtil;

import java.nio.ByteBuffer;

/**
 * @author hanjuntao
 * @date 2021/8/13
 */
public class MethodHandler implements BaseHandler {
    @Override
    public int order() {
        return 8;
    }

    @Override
    public void read(ByteBuffer codeBuffer, ClassFile classFile) {
        System.out.println("解析顺序：" + order());
        System.out.println(">>>>>>> 方法解析开始 >>>>>>>");

        U2 methodsCount = new U2(codeBuffer.get(), codeBuffer.get());
        classFile.setMethodsCount(methodsCount);

        Integer methodsCountInt = methodsCount.toInteger();
        System.out.println("方法数量：" + methodsCountInt);
        System.out.println("-----");

        if (methodsCountInt > 0) {
            MethodInfo[] methodInfos = new MethodInfo[methodsCountInt];

            for (int i = 0; i < methodsCountInt; i++) {
                MethodInfo methodInfo = new MethodInfo();
                methodInfo.setAccessFlags(new U2(codeBuffer.get(), codeBuffer.get()));
                methodInfo.setNameIndex(new U2(codeBuffer.get(), codeBuffer.get()));
                methodInfo.setDescriptorIndex(new U2(codeBuffer.get(), codeBuffer.get()));
                methodInfo.setAttributesCount(new U2(codeBuffer.get(), codeBuffer.get()));

                Integer attributesCount = methodInfo.getAttributesCount().toInteger();

                if (attributesCount != 0) {
                    AttributeInfo[] attributeInfos = AttributeUtil.parseAttributeInfos(codeBuffer, attributesCount);

                    methodInfo.setAttributes(attributeInfos);
                }

                System.out.println("原始信息：" + methodInfo);
                System.out.println("详细信息：" + methodInfo.detail(classFile));
                System.out.println("-----");

                methodInfos[i] = methodInfo;
            }

            classFile.setMethods(methodInfos);
        }

        System.out.println("<<<<<<< 方法解析结束 <<<<<<<");
        System.out.println();
    }
}
