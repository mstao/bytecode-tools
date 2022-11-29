package me.mingshan.bytecode.md.asm.myaop;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ChangeToChildConstructorMethodAdapter extends MethodVisitor {
    private final String superClassName;

    public ChangeToChildConstructorMethodAdapter(MethodVisitor mv,
                                                 String superClassName) {
        super(Opcodes.ASM9, mv);
        this.superClassName = superClassName;
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name,
                                String desc, boolean isInterface) {
        // 调用父类的构造函数时
        if (opcode == Opcodes.INVOKESPECIAL && name.equals("<init>")) {
            owner = superClassName;
        }
        super.visitMethodInsn(opcode, owner, name, desc, isInterface);// 改写父类为 superClassName
    }
}