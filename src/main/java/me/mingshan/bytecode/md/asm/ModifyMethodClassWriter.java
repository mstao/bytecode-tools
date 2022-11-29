package me.mingshan.bytecode.md.asm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ModifyMethodClassWriter extends ClassVisitor {

    private final ClassWriter classWriter;

    public ModifyMethodClassWriter(ClassWriter classWriter) {
        super(Opcodes.ASM9, classWriter);

        this.classWriter = classWriter;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        // 如果是getName，那么当前的MethodVisitor直接置空
        if (name.equals("getName")) {
            MethodVisitor methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
            // 返回自己改写过的MethodVisitor
            //            return new ModifyMethodWriter(methodVisitor);
        }
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }

    public byte[] toByteArray() {
        return this.classWriter.toByteArray();
    }
}

