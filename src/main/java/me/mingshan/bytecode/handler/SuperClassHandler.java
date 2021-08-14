package me.mingshan.bytecode.handler;

import me.mingshan.bytecode.type.constantpool.CONSTANT_Utf8_info;
import me.mingshan.bytecode.type.ClassFile;
import me.mingshan.bytecode.type.U2;
import me.mingshan.bytecode.util.ConstantPoolUtil;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author hanjuntao
 * @date 2021/8/13
 */
public class SuperClassHandler implements BaseHandler {
    @Override
    public int order() {
        return 5;
    }

    @Override
    public void read(ByteBuffer codeBuffer, ClassFile classFile) {
        System.out.println("解析顺序：" + order());
        System.out.println(">>>>>>> 父类索引解析开始 >>>>>>>");

        U2 superClass = new U2(codeBuffer.get(), codeBuffer.get());
        classFile.setSuperClass(superClass);
        System.out.println("父类常量池索引：" + superClass.toInteger());
        CONSTANT_Utf8_info classInfo = ConstantPoolUtil.getUtf8InfoByClassInfo(classFile, superClass.toInteger());
        assert classInfo != null;
        System.out.println("父类名：" + classInfo.detail());

        System.out.println("<<<<<<< 父类索引解析结束 <<<<<<<");
        System.out.println();
    }
}
