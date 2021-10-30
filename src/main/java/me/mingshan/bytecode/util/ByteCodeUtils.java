package me.mingshan.bytecode.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static me.mingshan.bytecode.Main.ASM_PATH;

public class ByteCodeUtils {
    public static void saveFile(byte[] bytes, String className) throws IOException {
        File file = new File( ASM_PATH + className + ".class");

        boolean newFile = file.createNewFile();

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(bytes);
        }
        
    }
}
