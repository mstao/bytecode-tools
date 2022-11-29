package me.mingshan.bytecode.parse.util;

import me.mingshan.bytecode.parse.type.AttributeInfo;
import me.mingshan.bytecode.parse.type.U2;
import me.mingshan.bytecode.parse.type.U4;

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
            Integer attributeLength = attributeInfo.getAttributeLength().toInteger();

            if (attributeLength > 0) {
                // 解析info
                byte[] info = new byte[attributeLength];
                codeBuffer.get(info, 0, info.length);
                attributeInfo.setInfo(info);
            }
            attributeInfos[j] = attributeInfo;
        }
        return attributeInfos;
    }
}
