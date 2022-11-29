package me.mingshan.bytecode.parse.handler.attribute;

import me.mingshan.bytecode.parse.type.*;
import me.mingshan.bytecode.parse.type.attribute.AttributeType;
import me.mingshan.bytecode.parse.type.attribute.BaseAttribute;
import me.mingshan.bytecode.parse.type.attribute.CodeAttribute;
import me.mingshan.bytecode.parse.type.attribute.ExceptionTable;
import me.mingshan.bytecode.parse.util.AttributeUtil;

import java.nio.ByteBuffer;

/**
 * @author hanjuntao
 * @date 2021/8/16
 */
public class CodeAttributeHandler implements BaseAttributeHandler {
    @Override
    public BaseAttribute processAttribute(ClassFile classFile, AttributeInfo attributeInfo) {
        CodeAttribute codeAttribute = new CodeAttribute(attributeInfo.getAttributeNameIndex(),
                attributeInfo.getAttributeLength());
        byte[] info = attributeInfo.getInfo();

        ByteBuffer byteBuffer = ByteBuffer.wrap(info);

        U2 maxStack = new U2(byteBuffer.get(), byteBuffer.get());
        U2 maxLocals = new U2(byteBuffer.get(), byteBuffer.get());
        U4 codeLength = new U4(byteBuffer.get(), byteBuffer.get(), byteBuffer.get(), byteBuffer.get());

        codeAttribute.setMaxStack(maxStack);
        codeAttribute.setMaxLocals(maxLocals);
        codeAttribute.setCodeLength(codeLength);

        Integer codeLengthInt = codeLength.toInteger();
        if (codeLengthInt > 0) {
            U1[] code = new U1[codeLengthInt];
            for (int i = 0; i < codeLengthInt; i++) {
                code[i] = new U1(byteBuffer.get());
            }
            codeAttribute.setCode(code);
        }

        U2 exceptionTableLength = new U2(byteBuffer.get(), byteBuffer.get());
        codeAttribute.setExceptionTableLength(exceptionTableLength);
        Integer exceptionTableLengthInt = exceptionTableLength.toInteger();

        if (exceptionTableLengthInt > 0) {
            ExceptionTable[] exceptionTables = new ExceptionTable[exceptionTableLengthInt];
            for (int i = 0; i < exceptionTableLengthInt; i++) {
                ExceptionTable exceptionTable = new ExceptionTable();
                U2 startPc = new U2(byteBuffer.get(), byteBuffer.get());
                U2 endPc = new U2(byteBuffer.get(), byteBuffer.get());
                U2 handlerPc = new U2(byteBuffer.get(), byteBuffer.get());
                U2 catchType = new U2(byteBuffer.get(), byteBuffer.get());
                exceptionTable.setStartPc(startPc);
                exceptionTable.setEndPc(endPc);
                exceptionTable.setHandlerPc(handlerPc);
                exceptionTable.setCatchType(catchType);
                exceptionTables[i] = exceptionTable;
            }

            codeAttribute.setExceptionTable(exceptionTables);
        }

        U2 attributesCount = new U2(byteBuffer.get(), byteBuffer.get());
        Integer attributesCountInt = attributesCount.toInteger();
        codeAttribute.setAttributesCount(attributesCount);

        AttributeInfo[] attributeInfos = AttributeUtil.parseAttributeInfos(byteBuffer, attributesCountInt);
        codeAttribute.setAttributes(attributeInfos);

        return codeAttribute;
    }

    @Override
    public AttributeType getType() {
        return AttributeType.Code;
    }
}
