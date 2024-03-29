package me.mingshan.bytecode.attribute;

import me.mingshan.bytecode.parse.handler.attribute.ParseAttributeFactory;
import me.mingshan.bytecode.parse.type.AttributeInfo;
import me.mingshan.bytecode.parse.type.ClassFile;
import me.mingshan.bytecode.parse.type.FieldInfo;
import me.mingshan.bytecode.parse.type.MethodInfo;
import me.mingshan.bytecode.parse.type.attribute.BaseAttribute;
import me.mingshan.bytecode.parse.util.ClassFileAnalysis;
import me.mingshan.bytecode.parse.util.FileUtil;
import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author hanjuntao
 * @date 2021/8/16
 */
public class AttributeTest {

    @Test
    public void test1() throws Exception {
        String filePath = "D:\\develop\\code\\bytecode-tools\\target\\classes\\me\\mingshan\\bytecode\\test\\SimpleDemo.class";
        ByteBuffer codeBuf = FileUtil.readFile(filePath);

        System.out.println("读取到缓冲区字节数：" + codeBuf.remaining());
        ClassFile classFile = ClassFileAnalysis.analysis(codeBuf);

        process(classFile, classFile.getAttributes());
    }

    private void process(ClassFile classFile, AttributeInfo[] attributes) {
        if (attributes != null && attributes.length > 0) {
            System.out.println(">>>>> 解析详细属性表信息 >>>>> ");

            for (AttributeInfo attributeInfo : attributes) {
                BaseAttribute baseAttribute = ParseAttributeFactory.parseAttribute(classFile, attributeInfo);
                if (baseAttribute != null) {
                    System.out.println("基础信息：" + baseAttribute);
                    System.out.println("详细信息：" + baseAttribute.detail(classFile));
                    System.out.println("---- ");
                    System.out.println();
                }
            }
        }
    }

    @Test
    public void test2() throws Exception {
        String filePath = "D:\\develop\\code\\bytecode-tools\\target\\classes\\me\\mingshan\\bytecode\\test\\SimpleDemo.class";
        ByteBuffer codeBuf = FileUtil.readFile(filePath);

        System.out.println("读取到缓冲区字节数：" + codeBuf.remaining());
        ClassFile classFile = ClassFileAnalysis.analysis(codeBuf);

        if (classFile.getFieldsCount().toInteger() > 0) {
            FieldInfo[] fields = classFile.getFields();

            for (FieldInfo fieldInfo : fields) {
                AttributeInfo[] attributes = fieldInfo.getAttributes();
                process(classFile, attributes);
            }
        }
    }

    @Test
    public void test3() throws Exception {
        String filePath = "D:\\develop\\code\\bytecode-tools\\target\\classes\\me\\mingshan\\bytecode\\test\\SimpleDemo.class";
        ByteBuffer codeBuf = FileUtil.readFile(filePath);

        System.out.println("读取到缓冲区字节数：" + codeBuf.remaining());
        ClassFile classFile = ClassFileAnalysis.analysis(codeBuf);

        if (classFile.getMethodsCount().toInteger() > 0) {
            MethodInfo[] methods = classFile.getMethods();

            for (MethodInfo methodInfo : methods) {
                AttributeInfo[] attributes = methodInfo.getAttributes();
                process(classFile, attributes);
            }
        }
    }
}
