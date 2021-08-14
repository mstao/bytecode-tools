package me.mingshan.bytecode.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * @author hanjuntao
 * @date 2021/8/13
 */
public class FileUtil {
    public static ByteBuffer readFile(String classFilePath) throws Exception {
        File file = new File(classFilePath);
        if (!file.exists()) {
            throw new Exception("file not exists!");
        }

        byte[] byteCodeBuf = new byte[4096];
        int length;
        try (InputStream in = new FileInputStream(file)) {
            length = in.read(byteCodeBuf);
        }

        if (length < 1) {
            throw new Exception("dididi");
        }

        return ByteBuffer.wrap(byteCodeBuf, 0, length).asReadOnlyBuffer();
    }
}
