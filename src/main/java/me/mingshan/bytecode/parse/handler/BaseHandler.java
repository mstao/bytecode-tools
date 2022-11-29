package me.mingshan.bytecode.parse.handler;

import me.mingshan.bytecode.parse.type.ClassFile;

import java.nio.ByteBuffer;

public interface BaseHandler {

    /**
     * 解释器的顺序
     *
     * @return 顺序
     */
    int order();

    /**
     * 读取字节码信息到ClassFile
     *
     * @param codeBuffer 字节码buffer
     * @param classFile  字节码类
     */
    void read(ByteBuffer codeBuffer, ClassFile classFile);
}
