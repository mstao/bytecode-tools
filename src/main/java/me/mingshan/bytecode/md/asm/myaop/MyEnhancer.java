package me.mingshan.bytecode.md.asm.myaop;

import me.mingshan.bytecode.classloader.MyClassLoader;
import me.mingshan.bytecode.parse.util.ByteCodeUtils;
import org.objectweb.asm.Type;

import java.lang.reflect.Modifier;

import static me.mingshan.bytecode.parse.Main.ASM_PATH;

public class MyEnhancer {
    private Class<?> superclass;
    private AopInterceptor interceptor;

    public void setSuperclass(Class<?> superclass) {
        if (superclass.isInterface()) {
            throw new RuntimeException("父类不能是接口！");
        }
        if (superclass == Object.class) {
            throw new RuntimeException("不能代理Object类！");
        }
        if ((superclass.getModifiers() & Modifier.FINAL) == Modifier.FINAL) {
            throw new RuntimeException("final类不允许继承！");
        }
        this.superclass = superclass;
    }

    public void setCallback(AopInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    public Object create() {
        if (superclass == null) {
            throw new RuntimeException("未设置父类！");
        }
        try {
            // 如果拦截器为空，无需创建代理类
            if (interceptor == null) {
                return superclass.newInstance();
            }
            String subclassName = Type.getInternalName(superclass);
            byte[] subclassByteCode = SubclassProxyFactory.createProxyClass(subclassName, superclass);

            String savePath = ASM_PATH + "\\myaop\\" + superclass.getSimpleName() + "$Proxy.class";
            ByteCodeUtils.saveFileByPath(subclassByteCode, savePath);
            MyClassLoader myClassLoader = new MyClassLoader(savePath);

            //me.mingshan.bytecode.md.asm.Demo
            Class<?> subclass = myClassLoader.loadClass(superclass.getName() + "$Proxy");
            return subclass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
