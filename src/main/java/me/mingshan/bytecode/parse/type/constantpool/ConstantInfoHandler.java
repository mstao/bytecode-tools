package me.mingshan.bytecode.parse.type.constantpool;

import java.nio.ByteBuffer;

/**
 * @author hanjuntao
 * @date 2021/8/10
 */
public interface ConstantInfoHandler {
    /**
     * 读取字节码信息到ClassFile
     *
     * @param codeBuffer 字节码buffer
     */
    void read(ByteBuffer codeBuffer);
}
