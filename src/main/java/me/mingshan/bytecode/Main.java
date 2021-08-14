package me.mingshan.bytecode;

import me.mingshan.bytecode.type.ClassFile;
import me.mingshan.bytecode.util.ClassFileAnalysis;
import me.mingshan.bytecode.util.FileUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) throws Exception {
        ByteBuffer codeBuf = FileUtil.readFile("target/classes/me/mingshan/bytecode/test/DemoImpl.class");
        //ByteBuffer codeBuf2 = readFile("target/classes/me/mingshan/bytecode/test/SimpleDemo.class");
        ClassFile classFile = ClassFileAnalysis.analysis(codeBuf);
        //System.out.println(classFile);
    }

}
