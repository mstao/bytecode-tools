package me.mingshan.bytecode.handler;

import me.mingshan.bytecode.type.ClassFile;
import me.mingshan.bytecode.type.U4;

import java.nio.ByteBuffer;

/**
 * 魔数解析器
 */
public class MagicHandler implements BaseHandler {
    @Override
    public int order() {
        return 0;
    }

    @Override
    public void read(ByteBuffer codeBuffer, ClassFile classFile) {
        System.out.println("解析顺序：" + order());
        System.out.println(">>>>>>> 魔数解析开始 >>>>>>>");
        U4 u4 = new U4(codeBuffer.get(), codeBuffer.get(), codeBuffer.get(), codeBuffer.get());
        classFile.setMagic(u4);

        System.out.println("魔数：" + u4.toHexString());

        System.out.println("<<<<<<< 魔数解析结束 <<<<<<<");
        System.out.println();
    }
}
