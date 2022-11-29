package me.mingshan.bytecode.parse.handler;

import me.mingshan.bytecode.parse.type.ClassFile;
import me.mingshan.bytecode.parse.type.U2;

import java.nio.ByteBuffer;

public class VersionHandler implements BaseHandler {
    @Override
    public int order() {
        return 1;
    }

    @Override
    public void read(ByteBuffer codeBuffer, ClassFile classFile) {
        System.out.println("解析顺序：" + order());
        System.out.println(">>>>>>> 版本号解析开始 >>>>>>>");

        U2 minorVersion = new U2(codeBuffer.get(), codeBuffer.get());
        classFile.setMinorVersion(minorVersion);

        U2 majorVersion = new U2(codeBuffer.get(), codeBuffer.get());
        classFile.setMajorVersion(majorVersion);

        System.out.println("主版本号：" + majorVersion.toInteger());
        System.out.println("副版本号：" + minorVersion.toInteger());

        System.out.println("<<<<<<< 版本号解析开始 <<<<<<<");
        System.out.println();
    }
}
