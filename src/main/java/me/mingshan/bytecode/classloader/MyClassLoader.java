package me.mingshan.bytecode.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * ClassLoader 类有三个重要的方法，分别是 loadClass、findClass 和 defineClass。
 * loadClass方法是加载目标类的入口，首先查找当前ClassLoader以及父加载器是否已经加载了目标类，
 * 如果都没有加载，且父加载器加载不到这个类，就会调用 findClass 让自己来加载目标类。
 * ClassLoader 的 findClass方法是需要子类重写的，在该方法中实现获取目标类的字节码，
 * 拿到类的字节码之后再调用 defineClass方法将字节码转换成Class对象。
 * <p>
 * 自定义类加载器需要继承ClassLoader，并重写findClass方法，在findClass方法中根据类名取得该类的字节码，
 * 再调用父类的defineClass方法完成类的加载。需要注意的是，findClass方法传递进行的类名是以符号“.”拼接的类名，
 * 不是“/”。使用“/”符号替代“ .”符号的类名称为类的内部名称或内部类名。
 */
public class MyClassLoader extends ClassLoader {

    private final String path;

    public MyClassLoader(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File(path);

        byte[] bytes;
        try {
            bytes = getClassBytes(file);
            // defineClass方法可以把二进制流字节组成的文件转换为一个java.lang.Class
            return this.defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            return super.findClass(name);
        }
    }

    private static byte[] getClassBytes(File file) throws Exception {
        // 这里要读入.class的字节，因此要使用字节流
        try (FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            FileChannel fc = fis.getChannel();
            WritableByteChannel wbc = Channels.newChannel(baos);
            ByteBuffer by = ByteBuffer.allocate(1024);

            while (true) {
                int i = fc.read(by);
                if (i == 0 || i == -1)
                    break;
                by.flip();
                wbc.write(by);
                by.clear();
            }

            return baos.toByteArray();
        }

    }
}
