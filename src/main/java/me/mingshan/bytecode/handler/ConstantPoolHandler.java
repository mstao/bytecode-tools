package me.mingshan.bytecode.handler;

import me.mingshan.bytecode.type.constantpool.CpInfoFactory;
import me.mingshan.bytecode.type.constantpool.CpInfoTagEnum;
import me.mingshan.bytecode.type.constantpool.NoSuchCpInfoException;
import me.mingshan.bytecode.type.ClassFile;
import me.mingshan.bytecode.type.CpInfo;
import me.mingshan.bytecode.type.U2;

import java.nio.ByteBuffer;

/**
 * @author hanjuntao
 * @date 2021/8/10
 */
public class ConstantPoolHandler implements BaseHandler {
    @Override
    public int order() {
        return 2;
    }

    @Override
    public void read(ByteBuffer codeBuffer, ClassFile classFile) {
        System.out.println("解析顺序：" + order());
        System.out.println(">>>>>>> 常量池解析开始 >>>>>>>");
        // 获取常量池计算器的值
        U2 constantPoolCount = new U2(codeBuffer.get(), codeBuffer.get());
        classFile.setConstantPoolCount(constantPoolCount);

        // 获取常量池常量的个数
        int cpLen = constantPoolCount.toInteger() - 1;
        classFile.setConstantPool(new CpInfo[cpLen]);

        System.out.println("常量池个数：" + cpLen);

        // 针对 long，double 优化，是否跳过常量池的下一项
        // 参考 https://github.com/wujiuye/bytecode-book/issues/1
        boolean skipNext = false;

        for (int i = 0; i < cpLen; i++) {
            if (skipNext) {
                System.out.println("序号: " + (i + 1) + "，跳过");
                skipNext = false;
                continue;
            }

            byte tag = codeBuffer.get();

            CpInfo cpInfo;
            try {
                cpInfo = CpInfoFactory.getCpInfo(tag);
            } catch (NoSuchCpInfoException e) {
                throw new RuntimeException("无效的tag：" + tag);
            }

            if (CpInfoTagEnum.CONSTANT_Double.equals(cpInfo.getTag())) {
                skipNext = true;
            }

            if (CpInfoTagEnum.CONSTANT_Long.equals(cpInfo.getTag())) {
                skipNext = true;
            }

            cpInfo.read(codeBuffer);
            System.out.println("序号: " + (i + 1) + "，内容 -- " + cpInfo);
            classFile.getConstantPool()[i] = cpInfo;
        }

        System.out.println("<<<<<<< 常量池解析结束 <<<<<<<");
        System.out.println();
    }
}
