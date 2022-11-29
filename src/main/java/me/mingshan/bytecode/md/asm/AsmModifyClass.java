package me.mingshan.bytecode.md.asm;

import me.mingshan.bytecode.parse.util.ByteCodeUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;

import static org.objectweb.asm.Opcodes.*;

public class AsmModifyClass {

    public static void addField(String className) throws IOException {
        // 类名，ASM根据类名从当前classpath去读取该类的class文件
        ClassReader classReader = new ClassReader(className);

        // ClassReader并不是访问者，但ClassReader类提供了accept方法用于接收一个ClassVisitor实例，
        // 由该ClassVisitor实例访问ClassReader实例解析后的class字节数组
        ClassWriter classWriter = new ClassWriter(0);
        classReader.accept(classWriter, 0);

        generateField(classWriter);

        ByteCodeUtils.saveFile(classWriter.toByteArray(),  "Demo");
    }

    private static void generateField(ClassWriter classWriter) {
        classWriter.visitField(ACC_PUBLIC | ACC_STATIC | ACC_FINAL, "CCC",
                "Ljava/lang/String;", null, "VVVVVVVVVVVVVV").visitEnd();
    }

    public static void removeMethod(String className) throws IOException {
        // 类名，ASM根据类名从当前classpath去读取该类的class文件
        ClassReader classReader = new ClassReader(className);

        // ClassReader并不是访问者，但ClassReader类提供了accept方法用于接收一个ClassVisitor实例，
        // 由该ClassVisitor实例访问ClassReader实例解析后的class字节数组
        ClassWriter classWriter = new ClassWriter(0);

        RemoveMethodClassWriter methodClassWriter = new RemoveMethodClassWriter(classWriter);

        /*
         * 我们在调用ClassReader实例的accept方法时，
         * accept方法会遍历ClassReader实例读取到的类的class文件结构的各项，
         * 遍历的目的是调用ClassWriter实例的相应visit方法，
         * 将ClassReader实例读取到的类的文件结构各项填充到ClassWriter实例的class文件结构。
         */
        classReader.accept(methodClassWriter, 0);
        ByteCodeUtils.saveFile(methodClassWriter.toByteArray(),  "Demo");
    }

    public static void modifyMethod(String className) throws IOException {
        // 类名，ASM根据类名从当前classpath去读取该类的class文件
        ClassReader classReader = new ClassReader(className);

        // ClassReader并不是访问者，但ClassReader类提供了accept方法用于接收一个ClassVisitor实例，
        // 由该ClassVisitor实例访问ClassReader实例解析后的class字节数组
        ClassWriter classWriter = new ClassWriter(0);

        ModifyMethodClassWriter methodClassWriter = new ModifyMethodClassWriter(classWriter);

        /*
         * 我们在调用ClassReader实例的accept方法时，
         * accept方法会遍历ClassReader实例读取到的类的class文件结构的各项，
         * 遍历的目的是调用ClassWriter实例的相应visit方法，
         * 将ClassReader实例读取到的类的文件结构各项填充到ClassWriter实例的class文件结构。
         */
        classReader.accept(methodClassWriter, 0);
        ByteCodeUtils.saveFile(methodClassWriter.toByteArray(),  "Demo");
    }

}
