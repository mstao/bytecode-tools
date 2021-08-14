package me.mingshan.bytecode.util;

import me.mingshan.bytecode.handler.*;
import me.mingshan.bytecode.type.ClassFile;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClassFileAnalysis {
    private static final List<BaseHandler> BYTE_CODE_HANDLERS = new ArrayList<>();

    static {
        BYTE_CODE_HANDLERS.add(new MagicHandler());
        BYTE_CODE_HANDLERS.add(new VersionHandler());
        BYTE_CODE_HANDLERS.add(new ConstantPoolHandler());
        BYTE_CODE_HANDLERS.add(new AccessFlagsHandler());
        BYTE_CODE_HANDLERS.add(new ThisClassHandler());
        BYTE_CODE_HANDLERS.add(new SuperClassHandler());
        BYTE_CODE_HANDLERS.add(new InterfaceHandler());
        BYTE_CODE_HANDLERS.add(new FieldHandler());
        BYTE_CODE_HANDLERS.add(new MethodHandler());
        BYTE_CODE_HANDLERS.add(new AttributeHandler());
    }

    public static ClassFile analysis(ByteBuffer codeBuffer) {
        System.err.println("字节码文件解析开始");
        System.out.println();

        codeBuffer.position(0);

        ClassFile classFile = new ClassFile();

        BYTE_CODE_HANDLERS.sort(Comparator.comparingInt(BaseHandler::order));

        for (BaseHandler baseHandler : BYTE_CODE_HANDLERS) {
            baseHandler.read(codeBuffer, classFile);
        }

        verify(codeBuffer);

        System.out.println();
        System.err.println("字节码文件解析完成");

        return classFile;
    }

    private static void verify(ByteBuffer codeBuffer) {
        boolean remaining = codeBuffer.hasRemaining();
        if (remaining) {
            throw new RuntimeException("缓冲区还有数据：" + codeBuffer.remaining() + "没有读取完");
        }
    }
}
