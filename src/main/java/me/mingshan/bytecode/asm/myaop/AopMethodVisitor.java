package me.mingshan.bytecode.asm.myaop;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class AopMethodVisitor extends MethodVisitor implements Opcodes {
    public AopMethodVisitor(int i, MethodVisitor methodVisitor) {
        super(i, methodVisitor);
    }

    public void visitCode() {
        super.visitCode();
        this.visitMethodInsn(INVOKESTATIC, AopInterceptor.class.getName().replace(".", "/"),
                "before", "()V", false);
    }

    public void visitInsn(int opcode) {
        if (opcode >= IRETURN && opcode <= RETURN) {
            this.visitMethodInsn(INVOKESTATIC, AopInterceptor.class.getName().replace(".", "/"),
                    "after", "()V", false);
        }
        super.visitInsn(opcode);
    }
}