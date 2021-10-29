package me.mingshan.bytecode.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteCodeUtils {
    public static void saveFile(byte[] bytes, String className) throws IOException {
        File file = new File( "D:\\develop\\code\\bytecode-tools\\src\\main\\java\\me\\mingshan\\bytecode\\asm\\" + className + ".class");

        boolean newFile = file.createNewFile();

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(bytes);
        }
        
    }
}
