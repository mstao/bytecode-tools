package me.mingshan.bytecode.asm.myaop;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Arrays;
import java.util.List;

public class AopClassAdapter extends ClassVisitor implements Opcodes {
    // 不拦截的方法
    private static final List<String> EXCLUDE_METHOD = Arrays.asList("wait", "equals",
            "toString", "hashCode", "getClass", "notify", "notifyAll");

    private String superName;

    public AopClassAdapter(ClassVisitor classVisitor, String superName) {
        super(ASM9, classVisitor);
        this.superName = superName;
    }

    @Override
    public void visit(
            int version,
            int access,
            String name,
            String signature,
            String superName,
            String[] interfaces) {
        // 更改类名，并使新类继承原有的类。
        super.visit(version, access, name + "$Proxy", signature, name, interfaces);
    }

    public MethodVisitor visitMethod(
            int access,
            String name,
            String desc,
            String signature,
            String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name,
                desc, signature, exceptions);
        // 忽略部分方法
        if (EXCLUDE_METHOD.contains(name)) {
            return mv;
        }

        if ("<init>".equals(name)) {
            return new ChangeToChildConstructorMethodAdapter(mv,
                    superName);
        }

        return new AopMethodVisitor(this.api, mv);
    }
}