package me.mingshan.bytecode;

import me.mingshan.bytecode.type.ClassFile;
import me.mingshan.bytecode.util.ClassFileAnalysis;
import me.mingshan.bytecode.util.FileUtil;

import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) throws Exception {
        //String filePath = "D:\\develop\\code\\data-hdy\\business-server\\business-wms-inventory-server\\target\\classes\\com\\service\\base\\wms\\inventory\\service\\impl\\InventoryDistinctKeyManager.class";
        //String filePath = "target/classes/me/mingshan/bytecode/type/CpInfo.class";
        String filePath = "D:\\develop\\MY\\CODE\\disruptor-3.4.4\\build\\classes\\java\\main\\com\\lmax\\disruptor\\RingBuffer.class";
        ByteBuffer codeBuf = FileUtil.readFile(filePath);

        System.out.println("读取到缓冲区字节数：" + codeBuf.remaining());
        ClassFile classFile = ClassFileAnalysis.analysis(codeBuf);
        //System.out.println(classFile);
    }

}
