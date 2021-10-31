package me.mingshan.bytecode.asm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

public class ModifyMethodWriter extends MethodVisitor {
    private final MethodVisitor methodVisitor;

    public ModifyMethodWriter(MethodVisitor methodVisitor) {
        super(Opcodes.ASM9, methodVisitor);

        this.methodVisitor = methodVisitor;
    }

    @Override
    public void visitCode() {
        super.visitCode();

        // System.out.println("hello word!");

        methodVisitor.visitFieldInsn(GETSTATIC,
                Type.getInternalName(System.class),
                "out",
                Type.getDescriptor(System.out.getClass()));
        methodVisitor.visitLdcInsn("hello word!");
        methodVisitor.visitMethodInsn(INVOKEVIRTUAL,
                Type.getInternalName(System.out.getClass()),
                "println",
                "(Ljava/lang/String;)V", false);
        methodVisitor.visitMaxs(2, 1);
    }
}