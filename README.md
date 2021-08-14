# bytecode-tools
Learn and parse java byte code.

阅读[《Java虚拟机字节码：从入门到实战》](https://weread.qq.com/web/reader/8d7327107217731e8d7ed1e)

# Java虚拟机规范

- [Java 规范列表](https://docs.oracle.com/javase/specs/index.html)
- [Java8 虚拟机规范](https://docs.oracle.com/javase/specs/jvms/se8/html/index.html)
- [字节码文件格式](https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.1)

# 字节码文件格式

```
ClassFile {
    u4             magic;   // 魔数
    u2             minor_version; // 副版本号
    u2             major_version; // 主版本号
    u2             constant_pool_count; // 常量池计数器
    cp_info        constant_pool[constant_pool_count-1]; // 常量池
    u2             access_flags; // 访问标志
    u2             this_class;   // 类索引
    u2             super_class;  // 父类索引
    u2             interfaces_count;  // 接口总数
    u2             interfaces[interfaces_count]; // 接口数组
    u2             fields_count; // 字段总数
    field_info     fields[fields_count]; // 字段表
    u2             methods_count; // 方法总数
    method_info    methods[methods_count];  // 方法表
    u2             attributes_count; // 属性总数
    attribute_info attributes[attributes_count]; // 属性表
}
```

其中 u2, u4 分别表示2字节和4字节。


# 文档列表

- [魔数和版本号](src/main/java/me/mingshan/bytecode/handler/doc/MagicAndVersion.md)
- [常量池](src/main/java/me/mingshan/bytecode/handler/ConstantPool.md)