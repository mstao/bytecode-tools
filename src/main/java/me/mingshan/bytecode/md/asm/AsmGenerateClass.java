package me.mingshan.bytecode.md.asm;

import me.mingshan.bytecode.parse.util.Utils;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import static org.objectweb.asm.Opcodes.*;

/**
 * https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html
 * https://asm.ow2.io/asm4-guide.pdf
 *
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
public class AsmGenerateClass {

    public static byte[] generate(EntityInfo entity) {
        /**
         * 0: 需要手动计算局部变量表和操作数栈的大小。
         *
         * COMPUTE_MAXS：自动计算局部变量表和操作数栈的大小。但仍然需要调用visitMax方法，
         * 只是你可以传递任意参数，ASM会忽略这些参数，并重新计算大小。
         *
         * COMPUTE_FRAMES：自动计算方法的栈映射桢。与自动计算局部变量表和操作数栈的大小一样，
         * 我们仍然需要调用visitFrame方法，但参数可以随意填。
         */
        ClassWriter cw = new ClassWriter(0);

        // 描述符
        // https://mingshan.fun/2018/09/18/fully-qualified-name-simple-name-descriptor
        // 泛型
        // https://blog.csdn.net/ryo1060732496/article/details/103655671

        /*
         * 第一个参数V1_8是生成的class的版本号， 对应class文件中的主版本号和次版本号， 即minor_version和major_version 。
         * 第二个参数ACC_PUBLIC表示该类的访问标识。这是一个public的类。 对应class文件中的access_flags 。
         * 第三个参数是生成的类的类名。 需要注意，这里是类的全限定名。
         * 第四个参数是和泛型相关的，  传入null表示这不是一个泛型类。这个参数对应class文件中的Signature属性（attribute） 。
         * 第五个参数是当前类的父类 该类直接继承Object。
         * 第六个参数是String[]类型的， 传入当前要生成的类的直接实现的接口。
         */
        String className = entity.getClassName().replace(".", "/");
        String signature = "<T:Ljava/lang/Object;>Ljava/lang/Object;";

        cw.visit(Opcodes.V1_8, // version
                ACC_PUBLIC, // access
                className, // name 全限定名
                signature, // 签名
                Object.class.getName().replace(".", "/"), // super class
                null // interface
        );

        //注解
        //AnnotationVisitor av = cw.visitAnnotation(Type.getType(Data.class).getDescriptor(), true);
        //注解参数
        // av.visit("xx", "xx");
        //av.visitEnd();

        // 定义默认构造方法
        generateInitMethod(cw);

        // 添加静态属性
        cw.visitField(ACC_PUBLIC | ACC_STATIC | ACC_FINAL, "ZZZ", "I", null, 100)
                .visitEnd();

        // 生成字段并生成字段的get/set方法
        generateFieldAndSetGetMethod(entity, cw, className);

        // 返回字节数组
        return cw.toByteArray();
    }

    private static void generateFieldAndSetGetMethod(EntityInfo entity, ClassWriter cw, String className) {

        for (EntityInfo.FieldInfo f : entity.getFields()) {
            String fieldName = f.getName();

            // Ljava.lang.String;
            String descriptor = Type.getType(f.getClassType()).getDescriptor();

            cw.visitField(ACC_PRIVATE, fieldName, descriptor, null, 0).visitEnd();

            // getMethod
            String getMethodName = "get" + Utils.toFirstUpperCase(fieldName);
            MethodVisitor getVisitor = cw.visitMethod(ACC_PUBLIC, getMethodName, "()" + descriptor, null, null);
            getVisitor.visitCode();
            getVisitor.visitVarInsn(ALOAD, 0);
            getVisitor.visitFieldInsn(GETFIELD, className, fieldName, descriptor);
            getVisitor.visitInsn(fetchLoadAndReturn(descriptor)[1]);
            getVisitor.visitMaxs(2, 1);
            getVisitor.visitEnd();

            // setMethod
            String setMethodName = "set" + Utils.toFirstUpperCase(fieldName);
            MethodVisitor setVisitor = cw.visitMethod(ACC_PUBLIC, setMethodName, "(" + descriptor + ")V", null, null);
            setVisitor.visitCode();
            setVisitor.visitVarInsn(ALOAD, 0);
            setVisitor.visitVarInsn(fetchLoadAndReturn(descriptor)[0], 1);
            setVisitor.visitFieldInsn(PUTFIELD, className, fieldName, descriptor);
            setVisitor.visitInsn(RETURN);
            setVisitor.visitMaxs(2, 2);
            setVisitor.visitEnd();
        }
    }

    private static void generateInitMethod(ClassWriter cw) {
        /*
         * 第一个参数是 ACC_PUBLIC ， 指定要生成的方法的访问标志。
         * 第二个参数是方法的方法名。 对于构造方法来说， 方法名为<init>
         * 第三个参数是方法描述符， 在这里要生成的构造方法无参数， 无返回值， 所以方法描述符为 ()V
         * 第四个参数是和泛型相关的， 这里传入null表示该方法不是泛型方法
         * 第五个参数指定方法声明可能抛出的异常。 这里无异常声明抛出
         */
        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);

        // 调用visitVarInsn方法，生成aload指令， 将第0个本地变量（也就是this）压入操作数栈。
        mv.visitVarInsn(ALOAD, 0);

        // 调用visitMethodInsn方法， 生成invokespecial指令， 调用父类（也就是Object）的构造方法。
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);

        // 调用visitInsn方法，生成return指令， 方法返回
        mv.visitInsn(RETURN);

        // 调用visitMaxs方法， 指定当前要生成的方法的最大局部变量和最大操作数栈
        mv.visitMaxs(1, 1);
        // 最后调用visitEnd方法， 表示当前要生成的构造方法已经创建完成
        mv.visitEnd();
    }

    private static int[] fetchLoadAndReturn(String typeof) {
        if (typeof.equals("I") || typeof.equals("Z")) {
            return new int[]{ILOAD, IRETURN};
        } else if (typeof.equals("J")) {
            return new int[]{LLOAD, LRETURN};
        } else if (typeof.equals("D")) {
            return new int[]{DLOAD, DRETURN};
        } else if (typeof.equals("F")) {
            return new int[]{FLOAD, FRETURN};
        } else {
            return new int[]{ALOAD, ARETURN};
        }
    }
}
