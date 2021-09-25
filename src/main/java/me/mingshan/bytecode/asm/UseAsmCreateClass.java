package me.mingshan.bytecode.asm;


import me.mingshan.bytecode.util.ByteCodeUtils;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.IOException;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

public class UseAsmCreateClass {
    public static void main(String[] args) throws IOException {
        String className = "me.mingshan.bytecode.asm.Demo";
        String signature = "L" + className.replace(".", "/") + ";";

        ClassWriter classWriter = new ClassWriter(0);

        classWriter.visit(Opcodes.V1_8, // version
                ACC_PUBLIC, // access
                className.replace(".", "/"), // name
                signature,
                Object.class.getName().replace(".", "/"), // super class
                null // interface
                );

        classWriter.visitEnd();

        byte[] bytes = classWriter.toByteArray();
        ByteCodeUtils.saveFile(bytes, "Demo");
    }
}
