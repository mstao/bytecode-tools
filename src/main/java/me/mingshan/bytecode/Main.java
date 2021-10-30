package me.mingshan.bytecode;

import me.mingshan.bytecode.util.ClassFileAnalysis;
import me.mingshan.bytecode.util.FileUtil;

import java.nio.ByteBuffer;

public class Main {
    public static final String ASM_PATH = "D:\\develop\\code\\bytecode-tools\\src\\main\\java\\me\\mingshan\\bytecode\\asm\\";

    public static void main(String[] args) throws Exception {
        String filePath = ASM_PATH + "Demo.class";
        ByteBuffer codeBuf = FileUtil.readFile(filePath);
        ClassFileAnalysis.analysis(codeBuf);
    }

}
