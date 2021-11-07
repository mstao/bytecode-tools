package me.mingshan.bytecode.util;

import me.mingshan.bytecode.classloader.MyClassLoader;

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

    public static void saveFileByPath(byte[] bytes, String path) throws IOException {
        File file = new File(path);

        boolean newFile = file.createNewFile();

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(bytes);
        }

    }

    /**
     * 加载类
     *
     * @param className 类名
     * @param byteCode  字节数组
     * @return
     * @throws ClassNotFoundException
     */
    public static Class loadClass(final String className, final byte[] byteCode) throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader(className);
        return myClassLoader.loadClass(className);
    }
}
