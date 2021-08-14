package me.mingshan.bytecode.handler;

import me.mingshan.bytecode.type.constantpool.CONSTANT_Utf8_info;
import me.mingshan.bytecode.type.ClassFile;
import me.mingshan.bytecode.type.U2;
import me.mingshan.bytecode.util.ConstantPoolUtil;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author hanjuntao
 * @date 2021/8/12
 */
public class ThisClassHandler implements BaseHandler {
    @Override
    public int order() {
        return 4;
    }

    @Override
    public void read(ByteBuffer codeBuffer, ClassFile classFile) {
        System.out.println("解析顺序：" + order());
        System.out.println(">>>>>>> 类索引解析开始 >>>>>>>");

        U2 thisClass = new U2(codeBuffer.get(), codeBuffer.get());
        classFile.setThisClass(thisClass);
        System.out.println("类常量池索引：" + thisClass.toInteger());

        CONSTANT_Utf8_info classInfo = ConstantPoolUtil.getUtf8InfoByClassInfo(classFile, thisClass.toInteger());
        assert classInfo != null;
        System.out.println("类名：" + classInfo.detail());

        System.out.println("<<<<<<< 类索引解析结束 <<<<<<<");
        System.out.println();
    }
}
