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
public class InterfaceHandler implements BaseHandler {
    @Override
    public int order() {
        return 6;
    }

    @Override
    public void read(ByteBuffer codeBuffer, ClassFile classFile) {
        System.out.println("解析顺序：" + order());
        System.out.println(">>>>>>> 接口解析开始 >>>>>>>");

        U2 interfacesCount = new U2(codeBuffer.get(), codeBuffer.get());
        classFile.setInterfacesCount(interfacesCount);

        Integer interfacesCountInt = interfacesCount.toInteger();
        System.out.println("接口数量：" + interfacesCountInt);

        U2[] interfaces = new U2[interfacesCountInt];

        for (int i = 0; i < interfacesCountInt; i++) {
            U2 u2 = new U2(codeBuffer.get(), codeBuffer.get());
            interfaces[i] = u2;
            System.out.println("接口常量池索引：" + u2.toInteger());
            CONSTANT_Utf8_info classInfo = ConstantPoolUtil.getUtf8InfoByClassInfo(classFile, u2.toInteger());
            assert classInfo != null;
            System.out.println("接口名：" + classInfo.detail());
        }

        classFile.setInterfaces(interfaces);

        System.out.println("<<<<<<< 接口解析结束 <<<<<<<");
        System.out.println();
    }
}
