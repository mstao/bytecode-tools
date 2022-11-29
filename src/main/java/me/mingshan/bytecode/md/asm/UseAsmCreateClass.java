package me.mingshan.bytecode.md.asm;


import me.mingshan.bytecode.parse.util.ByteCodeUtils;
import me.mingshan.bytecode.parse.util.Utils;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.io.IOException;

import static org.objectweb.asm.Opcodes.*;

/**
 * https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html
 * <p>
 * <p>
 * classWriter.visit 参数说明：
 * <p>
 * version：指定类文件结构的版本号；
 * access：指定类的访问标志，如public、final等；
 * name：指定类的名称（内部类名），如“java/lang/String”；
 * signature：类的类型签名，如“Ljava/lang/String;”；
 * superName：继承的父类名称。除Object类外，所有的类都必须有父类；
 * interfaces：该类需要实现的接口。
 * <p>
 * ----------------------------------------------------
 * <p>
 * MethodVisitor接口定义的几个常用API：
 * <p>
 * visitCode：访问方法的Code属性，实际上也是一个空方法，什么事情也不做；
 * visitMaxs：用于设置方法的局部变量表与操作数栈的大小；
 * <p>
 * MethodVisitor接口提供的编写字节码指令相关的API：
 * <p>
 * visitInsn：往Code属性的code数组中添加一条无操作数的字节码指令，如dup指令、aload_0指令等；
 * visitVarInsn：往Code属性的code数组中添加一条需要一个操作数的字节码指令，如aload指令；
 * visitFieldInsn：往Code属性的code数组中添加一条访问字段的字节码指令，用于添加putfield、getfield、putstatic、getstatic指令；
 * visitTypeInsn：往Code属性的code数组中添加一条操作数为常量池中某个CONSTANT_Class_info常量的索引的字节码指令，如new指令；
 * visitMethodInsn：往Code属性的code数组中添加一条调用方法的字节码指令，如invokevirtual指令。
 * <p>
 * ---------------------------------------------------
 * <p>
 * visitField方法的各参数说明：
 * <p>
 * access：字段的访问标志，如public、final、static；
 * name：字段的名称；
 * descriptor：字段的类型描述符，如”Ljava/lang/String;”;
 * signature：字段的类型签名；
 * value：字段的初始值，此参数只用于静态字段，如接口中声明的字段或类中声明的静态常量字段，并且类型必须是基本数据类型或String类型。
 */
public class UseAsmCreateClass {


    public static void generate() throws IOException {
        String className = "me.mingshan.bytecode.md.asm.Demo";
        //String signature = "L" + className.replace(".", "/") + ";";

        ClassWriter classWriter = new ClassWriter(0);

        classWriter.visit(Opcodes.V1_8, // version
                ACC_PUBLIC, // access
                className.replace(".", "/"), // name
                null,
                Object.class.getName().replace(".", "/"), // super class
                null // interface
        );

        // 添加<init>
        generateInitMethod(classWriter);

        // 添加字段
        generateField(classWriter, className);

        classWriter.visitEnd();

        byte[] bytes = classWriter.toByteArray();
        ByteCodeUtils.saveFile(bytes, "Demo");
    }

    /**
     * 生成<init>方法
     *
     * @param classWriter
     */
    public static void generateInitMethod(ClassWriter classWriter) {
        MethodVisitor methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        methodVisitor.visitCode();

        // 将第0个本地变量（也就是this）压入操作数栈。
        methodVisitor.visitVarInsn(ALOAD, 0);
        // 调用父类<init>
        methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        // 添加一条返回指令
        methodVisitor.visitInsn(RETURN);
        // 设置操作数栈和局部变量表大小
        methodVisitor.visitMaxs(1, 1);
        methodVisitor.visitEnd();
    }

    /**
     * 添加字段
     *
     * @param classWriter
     */
    private static void generateField(ClassWriter classWriter, String className) {
        // 添加静态属性
        classWriter.visitField(ACC_PUBLIC | ACC_STATIC | ACC_FINAL, "ZZZ", "I", null, 100)
        .visitEnd();

        String typeOf = Type.getType(String.class).getDescriptor();
        classWriter.visitField(ACC_PRIVATE, "name", typeOf, null, 0).visitEnd();

        generateGetSetMethod(classWriter, "name", className);
    }

    private static void generateGetSetMethod(ClassWriter classWriter, String fieldName, String className) {
        // 当要操作当前类的变量或方法时，需要先 aload_0, 然后再做相关操作！


        /*
         * aload_0
         * getfield
         * areturn
         */

        String getMethodName = "get" + Utils.toFirstUpperCase(fieldName);
        MethodVisitor getMethodVisitor = classWriter.visitMethod(ACC_PUBLIC, getMethodName, "()Ljava/lang/String;", null, null);
        getMethodVisitor.visitCode();
        getMethodVisitor.visitVarInsn(ALOAD, 0);
        getMethodVisitor.visitFieldInsn(GETFIELD, className, fieldName, "Ljava/lang/String;");
        getMethodVisitor.visitInsn(ARETURN);
        getMethodVisitor.visitMaxs(2, 1);
        getMethodVisitor.visitEnd();

        /*
         * aload_0
         * aload_1
         * putfield
         * return
         */
//
//        MethodVisitor setMethodVisitor = classWriter.visitMethod(ACC_PUBLIC, "set" + toFirst(fileName),
//                "(Ljava/lang/String;)V", null, null);
//        setMethodVisitor.visitCode();
//
//        setMethodVisitor.visitVarInsn(ALOAD, 0);
//        setMethodVisitor.visitVarInsn(ALOAD, 1);
//        setMethodVisitor.visitFieldInsn(PUTFIELD, className, fileName, "Ljava/lang/String;");
//
//        // 添加一条返回指令
//        setMethodVisitor.visitInsn(RETURN);
//        // 设置操作数栈和局部变量表大小
//        setMethodVisitor.visitMaxs(2, 2);
//        setMethodVisitor.visitEnd();
    }
}
