package me.mingshan.bytecode.md.jdk;

import java.lang.reflect.Proxy;

/**
 * @author hanjuntao
 * @date 2023/2/8
 */
public class Test {
    public static void main(String[] args) {
        //生成代理类文件 在根目录的同级目录，com下
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //实现了接口的业务类
        TestService service = new TestServiceImpl();
        //获取Class对象
        Class<?> iserviceClass = service.getClass();
        //代理类 实现需要实现InvocationHandler接口，重写invoke方法 传入业务实现类对象
        ProxyHandler proxyHandler = new ProxyHandler(service);

        //创建代理类对象
        TestService proxyInstance = (TestService) Proxy.newProxyInstance(iserviceClass.getClassLoader(),
                iserviceClass.getInterfaces(), proxyHandler);
        proxyInstance.hello();
    }
}
