package me.mingshan.bytecode.util;

import me.mingshan.bytecode.type.AttributeInfo;
import me.mingshan.bytecode.type.U2;
import me.mingshan.bytecode.type.U4;

import java.nio.ByteBuffer;

/**
 * @author hanjuntao
 * @date 2021/8/14
 */
public class AttributeUtil {

    public static AttributeInfo[] parseAttributeInfos(ByteBuffer codeBuffer, Integer attributesCount) {
        AttributeInfo[] attributeInfos = new AttributeInfo[attributesCount];
        for (int j = 0; j < attributesCount; j++) {
            AttributeInfo attributeInfo = new AttributeInfo();
            attributeInfo.setAttributeNameIndex(new U2(codeBuffer.get(), codeBuffer.get()));
            attributeInfo.setAttributeLength(new U4(codeBuffer.get(), codeBuffer.get(), codeBuffer.get(), codeBuffer.get()));

            // 解析info
            byte[] info = new byte[attributeInfo.getAttributeLength().toInteger()];
            codeBuffer.get(info, 0, info.length);
            attributeInfo.setInfo(info);
            attributeInfos[j] = attributeInfo;
        }
        return attributeInfos;
    }
}
