package me.mingshan.bytecode.parse.handler;

import me.mingshan.bytecode.parse.type.ClassFile;
import me.mingshan.bytecode.parse.type.U2;
import me.mingshan.bytecode.parse.util.AccessFlagsUtil;

import java.nio.ByteBuffer;

/**
 * 访问标志处理器
 *
 * @author hanjuntao
 * @date 2021/8/12
 */
public class AccessFlagsHandler implements BaseHandler {
    @Override
    public int order() {
        return 3;
    }

    @Override
    public void read(ByteBuffer codeBuffer, ClassFile classFile) {
        System.out.println("解析顺序：" + order());
        System.out.println(">>>>>>> 访问标志解析开始 >>>>>>>");

        U2 accessFlags = new U2(codeBuffer.get(), codeBuffer.get());
        classFile.setAccessFlags(accessFlags);

        System.out.println("访问标志：" + accessFlags.toHexString());

        System.out.println("详细：" + AccessFlagsUtil.parseClassAccessFlag(accessFlags.toInteger()));

        System.out.println("<<<<<<< 访问标志解析结束 <<<<<<<");
        System.out.println();
    }

}
