package me.mingshan.bytecode;

import me.mingshan.bytecode.util.ClassFileAnalysis;
import me.mingshan.bytecode.util.FileUtil;

import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) throws Exception {
        //String filePath = "D:\\develop\\MY\\CODE\\disruptor-3.4.4\\build\\classes\\java\\main\\com\\lmax\\disruptor\\RingBuffer.class";
        String filePath = "D:\\develop\\code\\bytecode-tools\\src\\main\\java\\me\\mingshan\\bytecode\\asm\\Demo.class";
        ByteBuffer codeBuf = FileUtil.readFile(filePath);
        ClassFileAnalysis.analysis(codeBuf);
    }

}
