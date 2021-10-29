package me.mingshan.bytecode.asm;


import me.mingshan.bytecode.util.ByteCodeUtils;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.IOException;

import static org.objectweb.asm.Opcodes.*;

/**
 *
 * https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html
 *
 *
 * classWriter.visit 参数说明：
 *
 * version：指定类文件结构的版本号；
 * access：指定类的访问标志，如public、final等；
 * name：指定类的名称（内部类名），如“java/lang/String”；
 * signature：类的类型签名，如“Ljava/lang/String;”；
 * superName：继承的父类名称。除Object类外，所有的类都必须有父类；
 * interfaces：该类需要实现的接口。
 *
 * ----------------------------------------------------
 *
 * MethodVisitor接口定义的几个常用API：
 *
 * visitCode：访问方法的Code属性，实际上也是一个空方法，什么事情也不做；
 * visitMaxs：用于设置方法的局部变量表与操作数栈的大小；
 *
 * MethodVisitor接口提供的编写字节码指令相关的API：
 *
 * visitInsn：往Code属性的code数组中添加一条无操作数的字节码指令，如dup指令、aload_0指令等；
 * visitVarInsn：往Code属性的code数组中添加一条需要一个操作数的字节码指令，如aload指令；
 * visitFieldInsn：往Code属性的code数组中添加一条访问字段的字节码指令，用于添加putfield、getfield、putstatic、getstatic指令；
 * visitTypeInsn：往Code属性的code数组中添加一条操作数为常量池中某个CONSTANT_Class_info常量的索引的字节码指令，如new指令；
 * visitMethodInsn：往Code属性的code数组中添加一条调用方法的字节码指令，如invokevirtual指令。
 *
 *---------------------------------------------------
 *
 * visitField方法的各参数说明：
 *
 * access：字段的访问标志，如public、final、static；
 * name：字段的名称；
 * descriptor：字段的类型描述符，如”Ljava/lang/String;”;
 * signature：字段的类型签名；
 * value：字段的初始值，此参数只用于静态字段，如接口中声明的字段或类中声明的静态常量字段，并且类型必须是基本数据类型或String类型。
 *
 */
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

        // 添加<init>
        generateInitMethod(classWriter);

        // 添加字段
        generateField(classWriter);

        classWriter.visitEnd();

        byte[] bytes = classWriter.toByteArray();
        ByteCodeUtils.saveFile(bytes, "Demo");
    }

    private static void generateField(ClassWriter classWriter) {
        classWriter.visitField(ACC_PRIVATE | ACC_STATIC | ACC_FINAL, "age", "I",  null, 100);


    }

    /**
     * 生成<init></init>方法
     *
     * @param classWriter
     */
    public static void generateInitMethod(ClassWriter classWriter){
        MethodVisitor methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        methodVisitor.visitCode();
        // 调用父类构造器
        methodVisitor.visitVarInsn(ALOAD, 0);
        // 调用父类<init>
        methodVisitor.visitMethodInsn(INVOKESPECIAL,"java/lang/Object","<init>", "()V", false);
        // 添加一条返回指令
        methodVisitor.visitInsn(RETURN);
        // 设置操作数栈和局部变量表大小
        methodVisitor.visitMaxs(1,1);
        methodVisitor.visitEnd();
    }
}
