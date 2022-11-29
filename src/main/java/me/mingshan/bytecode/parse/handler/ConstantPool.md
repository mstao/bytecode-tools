# JVM 文档位置
https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4

# 常量池结构

常量池是一个数组，数组中的每一个元素的结构如下所示:

```
cp_info {
    u1 tag;
    u1 info[];
}
```

- tag值用于标志一个常量是哪种常量结构。
只有根据tag确定常量的结构，才能根据常量结构计算常量所占用的字节数。
- info[]字节数组存储的内容和长度由tag值决定

下面是tag的类型对应的值：

ConstantType |	Value | Desc
---|---|---
CONSTANT_Class     |	7 | 类或者接口的符号引用
CONSTANT_Fieldref	| 9 | 字段的符号引用
CONSTANT_Methodref	| 10 | 类中的方法符号引用
CONSTANT_InterfaceMethodref	 | 11 | 接口中方法符号引用
CONSTANT_String	| 8  | 字符串类型字面量
CONSTANT_Integer	| 3 | 整形类型字面量
CONSTANT_Float	| 4 | 浮点数类型字面量
CONSTANT_Long	| 5 | 长整型类型字面量
CONSTANT_Double | 	6 | 双浮点类型字面量
CONSTANT_NameAndType |	12 | 字段与字段类型或方法与方法类型的符号引用
CONSTANT_Utf8	| 1 | UTF-8字符串
CONSTANT_MethodHandle  |	15 | 方法句柄
CONSTANT_MethodType |	16 | 方法类型
CONSTANT_InvokeDynamic |	18 | 动态方法调用点
CONSTANT_Module  | 19 | 模块化
CONSTANT_Package | 20 | 未知


源代码位置：hotspot/src/share/vm/prims/jvm.h

```
enum {
    JVM_CONSTANT_Utf8 = 1,      // 1
    JVM_CONSTANT_Unicode,       // 2      /* unused */
    JVM_CONSTANT_Integer,       // 3
    JVM_CONSTANT_Float,         // 4
    JVM_CONSTANT_Long,          // 5
    JVM_CONSTANT_Double,        // 6
    JVM_CONSTANT_Class,         // 7
    JVM_CONSTANT_String,        // 8
    JVM_CONSTANT_Fieldref,      // 9
    JVM_CONSTANT_Methodref,     // 10
    JVM_CONSTANT_InterfaceMethodref,   // 11
    JVM_CONSTANT_NameAndType,          // 12
    JVM_CONSTANT_MethodHandle           = 15,  // JSR 292
    JVM_CONSTANT_MethodType             = 16,  // JSR 292
    //JVM_CONSTANT_(unused)             = 17,  // JSR 292 early drafts only
    JVM_CONSTANT_InvokeDynamic          = 18,  // JSR 292
    JVM_CONSTANT_ExternalMax            = 18   // Last tag found in classfiles
};
```

# The CONSTANT_Utf8_info Structure

`CONSTANT_Utf8_info` 常量结构用于存储字符串常量，字符串编码使用UTF-8。其结构如下：

```
CONSTANT_Utf8_info {
    u1 tag;
    u2 length;
    u1 bytes[length];
}
```

**tag**

The tag item of the CONSTANT_Utf8_info structure has the value CONSTANT_Utf8 (1).

tag 就是上表中的 `CONSTANT_Utf8` ，值为1

**length**

The value of the length item gives the number of bytes in the bytes array (not the length of the resulting string).

length 描述字符串字节数组的长度

**bytes[]**

存储字符串的字节数据，长度由length决定

- The bytes array contains the bytes of the string.
- No byte may have the value (byte)0.
- No byte may lie in the range (byte)0xf0 to (byte)0xff.

# The CONSTANT_Class_Info Structure

`CONSTANT_Class_Info`常量存储类的符号信息，除tag字段外，
只有一个存储指向常量池表中某一常量的索引字段name_index，
name_index指向的常量必须是一个CONSTANT_Utf8_info常量，该常量存储class的类名.

```
CONSTANT_Class_info {
    u1 tag;
    u2 name_index;
}
```

**tag**

The tag item has the value CONSTANT_Class (7).

tag 就是上表中的 `CONSTANT_Class` ，值为7

**name_index**

The value of the name_index item must be a valid index into the constant_pool table. 
The constant_pool entry at that index must be a CONSTANT_Utf8_info structure (§4.4.7) 
representing a valid binary class or interface name encoded in internal form (§4.2.1).

name_index指向的常量必须是一个CONSTANT_Utf8_info常量，该常量存储class的类名.

# The CONSTANT_Fieldref_info, CONSTANT_Methodref_info, and CONSTANT_InterfaceMethodref_info Structures

`CONSTANT_Fieldref_info`常量存储字段的符号信息
`CONSTANT_Methodref_info`常量存储类方法的符号信息
`CONSTANT_InterfaceMethodref_info`常量存储接口方法的符号信息

三者的结构一致，如下：

```
CONSTANT_Fieldref_info {
    u1 tag;
    u2 class_index;
    u2 name_and_type_index;
}

CONSTANT_Methodref_info {
    u1 tag;
    u2 class_index;
    u2 name_and_type_index;
}

CONSTANT_InterfaceMethodref_info {
    u1 tag;
    u2 class_index;
    u2 name_and_type_index;
}
```

**tag**

The tag item of a CONSTANT_Fieldref_info structure has the value CONSTANT_Fieldref (9).

`CONSTANT_Fieldref_info` 的tag 为 CONSTANT_Fieldref (9)

The tag item of a CONSTANT_Methodref_info structure has the value CONSTANT_Methodref (10).

`CONSTANT_Methodref_info` 的tag 为 CONSTANT_Methodref (10)

The tag item of a CONSTANT_InterfaceMethodref_info structure has the value CONSTANT_InterfaceMethodref (11).

`CONSTANT_InterfaceMethodref_info` 的tag 为 CONSTANT_InterfaceMethodref (11)

**class_index**

The value of the class_index item must be a valid index into the constant_pool table. The constant_pool entry at that 
index must be a CONSTANT_Class_info structure (§4.4.1) representing a class or interface type that has the field or method as a member.

- The class_index item of a CONSTANT_Methodref_info structure must be a class type, not an interface type.
- The class_index item of a CONSTANT_InterfaceMethodref_info structure must be an interface type.
- The class_index item of a CONSTANT_Fieldref_info structure may be either a class type or an interface type.

`class_index`指向的常量必须是一个`CONSTANT_Class_Info`常量，表示当前字段所在的类的类名 或者接口名；

- `CONSTANT_Methodref_info` 指向的是类
- `CONSTANT_InterfaceMethodref_info` 指向的是接口
- `CONSTANT_Fieldref_info` 指向的既可以是类也可以是接口

**name_and_type_index**

The value of the name_and_type_index item must be a valid index into the constant_pool table. The constant_pool entry at that index must be a CONSTANT_NameAndType_info structure (§4.4.6). This constant_pool entry indicates the name and descriptor of the field or method.

In a CONSTANT_Fieldref_info, the indicated descriptor must be a field descriptor (§4.3.2). Otherwise, the indicated descriptor must be a method descriptor (§4.3.3).

If the name of the method of a CONSTANT_Methodref_info structure begins with a '<' ('\u003c'), then the name must be the special name <init>, representing an instance initialization method (§2.9). The return type of such a method must be void.


`name_and_type_index`指向的常量必须是一个CONSTANT_NameAndType_info常量:
- 如果是`CONSTANT_Fieldref_info`，表示当前字段的名字和类型描述符。
- 如果是`CONSTANT_Methodref_info`，表示当前类的方法的名字和类型描述符。
- 如果是`CONSTANT_InterfaceMethodref_info`，表示当前接口的方法的名字和类型描述符。

# The CONSTANT_String_info Structure

`CONSTANT_String_info`结构存储Java中String类型的常量

```
CONSTANT_String_info {
    u1 tag;
    u2 string_index;
}
```

**tag**

The tag item of the CONSTANT_String_info structure has the value CONSTANT_String (8).

`CONSTANT_String_info` 的tag为CONSTANT_String (8)

**string_index**

The value of the string_index item must be a valid index into the constant_pool table.
The constant_pool entry at that index must be a CONSTANT_Utf8_info structure (§4.4.7) representing the sequence of Unicode code points to which the String object is to be initialized.

string_index，值为常量池中某个常量的索引，该索引指向的常量必须是一个CONSTANT_Utf8_info常量。

# The CONSTANT_Integer_info and CONSTANT_Float_info Structures

`CONSTANT_Integer_info`常量存储一个整型数值;
`CONSTANT_Float_info`常量存储一个单浮点数值。

```
CONSTANT_Integer_info {
    u1 tag;
    u4 bytes;
}

CONSTANT_Float_info {
    u1 tag;
    u4 bytes;
}
```

**tag**

The tag item of the CONSTANT_Integer_info structure has the value CONSTANT_Integer (3).

`CONSTANT_Integer_info` 的tag为 CONSTANT_Integer (3)

The tag item of the CONSTANT_Float_info structure has the value CONSTANT_Float (4).

`CONSTANT_Float_info` 的tag为 CONSTANT_Float (4)

**bytes**

bytes存储实际的值

The bytes item of the CONSTANT_Integer_info structure represents the value of the int constant. The bytes of the value are stored in big-endian (high byte first) order.

对于`CONSTANT_Integer_info`, bytes转为10进制数就是这个常量所表示的整型值

The bytes item of the CONSTANT_Float_info structure represents the value of the float constant in IEEE 754 floating-point single format (§2.3.2). The bytes of the single format representation are stored in big-endian (high byte first) order.bytes转为10进制数就是这个常量所表示的整型值

对于`CONSTANT_Float_info`，bytes转为10进制数就是这个常量所表示的浮点数值


# The CONSTANT_Long_info and CONSTANT_Double_info Structures


`CONSTANT_Long_info`常量存储一个长整型数值;
`CONSTANT_Double_info`常量存储一个双浮点数值。

```
CONSTANT_Long_info {
    u1 tag;
    u4 high_bytes;
    u4 low_bytes;
}

CONSTANT_Double_info {
    u1 tag;
    u4 high_bytes;
    u4 low_bytes;
}
```

**tag**

The tag item of the CONSTANT_Long_info structure has the value CONSTANT_Long (5).

`CONSTANT_Long_info` 的tag为CONSTANT_Long (5)

The tag item of the CONSTANT_Double_info structure has the value CONSTANT_Double (6).

`CONSTANT_Double_info`的tag为CONSTANT_Double (6)

**high_bytes, low_bytes**

The unsigned high_bytes and low_bytes items of the CONSTANT_Long_info structure together represent the value of the long constant。

CONSTANT_Long_info常量使用8个字节存储一个长整型数值，即使用两个U4类型的字段分别存储一个长整型数的高32位和低32位。

# The CONSTANT_NameAndType_info Structure

`CONSTANT_NameAndType_info`结构用于存储字段的名称和字段的类型描述符，或者是用于存储方法的名称和方法的描述符。

The CONSTANT_NameAndType_info structure is used to represent a field or method,
without indicating which class or interface type it belongs to:

```
CONSTANT_NameAndType_info {
    u1 tag;
    u2 name_index;
    u2 descriptor_index;
}
```

**tag**

The tag item of the CONSTANT_NameAndType_info structure has the value CONSTANT_NameAndType (12).

`CONSTANT_NameAndType_info` 的tag为CONSTANT_NameAndType (12)

**name_index**

The value of the name_index item must be a valid index into the constant_pool table. The constant_pool entry at that index must be a CONSTANT_Utf8_info structure (§4.4.7) representing either the special method name <init> (§2.9) or a valid unqualified name denoting a field or method (§4.2.2).

name_index对应名称指向常量池中某个常量的索引

**descriptor_index**

The value of the descriptor_index item must be a valid index into the constant_pool table. The constant_pool entry at that index must be a CONSTANT_Utf8_info structure (§4.4.7) representing a valid field descriptor or method descriptor (§4.3.2, §4.3.3).

descriptor_index对应描述符指向常量池中某个常量的索引

# 参考：
- https://www.cnblogs.com/mazhimazhi/p/13407690.html