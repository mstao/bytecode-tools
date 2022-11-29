package me.mingshan.bytecode.attribute;

import me.mingshan.bytecode.md.asm.AsmExtendClass;
import me.mingshan.bytecode.md.asm.AsmGenerateClass;
import me.mingshan.bytecode.md.asm.AsmModifyClass;
import me.mingshan.bytecode.md.asm.EntityInfo;
import me.mingshan.bytecode.classloader.MyClassLoader;
import me.mingshan.bytecode.parse.util.ByteCodeUtils;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static me.mingshan.bytecode.parse.Main.ASM_PATH;

public class AsmTest {

    @Test
    public void test1() throws IOException {
        EntityInfo entityInfo = new EntityInfo();
        entityInfo.setClassName("me.mingshan.bytecode.md.asm.Demo");
        EntityInfo.FieldInfo fieldInfo1 = new EntityInfo.FieldInfo();
        fieldInfo1.setName("name");
        fieldInfo1.setClassType(String.class);

        List<EntityInfo.FieldInfo> fieldInfoList = new ArrayList<>();
        fieldInfoList.add(fieldInfo1);

        entityInfo.setFields(fieldInfoList);

        byte[] bytes = AsmGenerateClass.generate(entityInfo);
        ByteCodeUtils.saveFile(bytes, "Demo");
    }

    @Test
    public void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        String path = ASM_PATH + "Demo.class";

        MyClassLoader myClassLoader = new MyClassLoader(path);
        Class<?> clazz = myClassLoader.loadClass("me.mingshan.bytecode.md.asm.Demo");

        /*
         * Caused by: java.lang.NoSuchMethodException: me.mingshan.bytecode.md.asm.Demo.<init>()
         * 	at java.lang.Class.getConstructor0(Class.java:3082)
         * 	at java.lang.Class.newInstance(Class.java:412)
         * 	... 1 more
         */

        /*
         * Exception in thread "main" java.lang.ClassFormatError: Illegal class name "me.mingshan.bytecode.md.asm.Demo" in class file me/mingshan/bytecode/asm/Demo
         * 	at java.lang.ClassLoader.defineClass1(Native Method)
         * 	at java.lang.ClassLoader.defineClass(ClassLoader.java:756)
         * 	at java.lang.ClassLoader.defineClass(ClassLoader.java:635)
         * 	at me.mingshan.bytecode.classloader.MyClassLoader.findClass(MyClassLoader.java:38)
         * 	at java.lang.ClassLoader.loadClass(ClassLoader.java:418)
         * 	at java.lang.ClassLoader.loadClass(ClassLoader.java:351)
         * 	at me.mingshan.bytecode.md.asm.Test.main(Test.java:10)
         */

        Object o = clazz.newInstance();

        Field zzz = clazz.getField("ZZZ");
        System.out.println(zzz.get(null));

        Method setNameMethod = clazz.getMethod("setName", String.class);
        setNameMethod.invoke(o, "77777");

        Method getNameMethod = clazz.getMethod("getName");
        Object result = getNameMethod.invoke(o);
        System.out.println(result);
    }

    @Test
    public void test3() throws IOException {
        AsmModifyClass.addField("me.mingshan.bytecode.md.asm.Demo");
    }

    @Test
    public void test4() throws IOException {
        AsmModifyClass.removeMethod("me.mingshan.bytecode.md.asm.Demo");
    }

    @Test
    public void test5() throws IOException {
        AsmModifyClass.modifyMethod("me.mingshan.bytecode.md.asm.Demo");
    }

    @Test
    public void test6() throws IOException {
        AsmExtendClass.generate();
    }
}
