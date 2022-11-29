package me.mingshan.bytecode.md.asm.myaop;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;

import java.io.IOException;

public class SubclassProxyFactory {

    public static byte[] createProxyClass(String className, Class<?> superclass) throws IOException {

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

        ClassReader reader = new ClassReader(className);
        String subclassName = Type.getInternalName(superclass);
        reader.accept(new AopClassAdapter(cw, subclassName), ClassReader.SKIP_DEBUG);

        return cw.toByteArray();
    }

}
