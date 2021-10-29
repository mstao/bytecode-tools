package me.mingshan.bytecode.asm;

import com.sun.xml.internal.ws.util.StringUtils;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author hanjuntao
 * @date 2021/10/29
 */
public class AsmBean {

    public static byte[] generate(BeanEnityInfo entity) {
        ClassWriter cw = new ClassWriter(0);

        /**
         * 第一个参数V1_1是生成的class的版本号， 对应class文件中的主版本号和次版本号， 即minor_version和major_version 。
         * 第二个参数ACC_PUBLIC表示该类的访问标识。这是一个public的类。 对应class文件中的access_flags 。
         * 第三个参数是生成的类的类名。 需要注意，这里是类的全限定名。 如果生成的class带有包名， 如com.xuyw.Test，
         * 那么这里传入的参数必须是com/xuyw/Test  。对应class文件中的this_class
         * 第四个参数是和泛型相关的，  传入null表示这不是一个泛型类。这个参数对应class文件中的Signature属性（attribute） 。
         * 第五个参数是当前类的父类 该类直接继承Object。
         * 第六个参数是String[]类型的， 传入当前要生成的类的直接实现的接口。
         */
        String className = entity.getClassName().replace(".", "/");
        cw.visit(V1_8, ACC_PUBLIC, className, null, "java/lang/Object", null);
        //注解
        //AnnotationVisitor av = cw.visitAnnotation(Type.getType(Data.class).getDescriptor(), true);
        //注解参数
        // av.visit("xx", "xx");
        //av.visitEnd();
        // 定义默认构造方法
        /**
         * 第一个参数是 ACC_PUBLIC ， 指定要生成的方法的访问标志。
         * 第二个参数是方法的方法名。 对于构造方法来说， 方法名为<init>
         * 第三个参数是方法描述符， 在这里要生成的构造方法无参数， 无返回值， 所以方法描述符为 ()V
         * 第四个参数是和泛型相关的， 这里传入null表示该方法不是泛型方法
         * 第五个参数指定方法声明可能抛出的异常。 这里无异常声明抛出
         */
        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        //调用visitVarInsn方法，生成aload指令， 将第0个本地变量（也就是this）压入操作数栈。
        mv.visitVarInsn(ALOAD, 0);
        //调用visitMethodInsn方法， 生成invokespecial指令， 调用父类（也就是Object）的构造方法。
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        //调用visitInsn方法，生成return指令， 方法返回
        mv.visitInsn(RETURN);
        //调用visitMaxs方法， 指定当前要生成的方法的最大局部变量和最大操作数栈
        mv.visitMaxs(1, 1);
        //最后调用visitEnd方法， 表示当前要生成的构造方法已经创建完成
        mv.visitEnd();
        for (BeanEnityInfo.FieldInfo f : entity.getFields()) {
            String fieldName = f.getName();
            String typeOf = Type.getType(f.getClassType()).getDescriptor();
            cw.visitField(ACC_PRIVATE, fieldName, typeOf, null, 0).visitEnd();
            // getMethod
            String getMethodName = "get" + StringUtils.capitalize(fieldName);
            mv = cw.visitMethod(ACC_PUBLIC, getMethodName, "()" + typeOf, null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, className, fieldName, typeOf);
            mv.visitInsn(loadAndReturnOf(typeOf)[1]);
            mv.visitMaxs(2, 1);
            mv.visitEnd();
            String setMethodName = "set" + StringUtils.capitalize(fieldName);
            // setMethod
            mv = cw.visitMethod(ACC_PUBLIC, setMethodName, "(" + typeOf + ")V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(loadAndReturnOf(typeOf)[0], 1);
            mv.visitFieldInsn(PUTFIELD, className, fieldName, typeOf);
            mv.visitInsn(RETURN);
            mv.visitMaxs(3, 3);
            mv.visitEnd();
        }
        return cw.toByteArray();
    }

    private static int[] loadAndReturnOf(String typeof) {
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
