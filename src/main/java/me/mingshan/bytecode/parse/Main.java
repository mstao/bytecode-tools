package me.mingshan.bytecode.parse;

import me.mingshan.bytecode.parse.util.ClassFileAnalysis;
import me.mingshan.bytecode.parse.util.FileUtil;

import java.nio.ByteBuffer;

public class Main {
    public static final String ASM_PATH = "D:\\develop\\code\\bytecode-tools\\target\\classes\\me\\mingshan\\bytecode\\asm\\";

    public static void main(String[] args) throws Exception {
        //String filePath = ASM_PATH + "Demo.class";
        String filePath = "D:\\develop\\code\\bytecode-tools\\target\\classes\\me\\mingshan\\bytecode\\test\\SimpleDemo.class";
        ByteBuffer codeBuf = FileUtil.readFile(filePath);
        ClassFileAnalysis.analysis(codeBuf);
    }

}
