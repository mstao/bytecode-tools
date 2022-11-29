package me.mingshan.bytecode.parse.util;

import me.mingshan.bytecode.parse.type.AccessFlagEnum;
import me.mingshan.bytecode.parse.type.FieldAccessFlagEnum;
import me.mingshan.bytecode.parse.type.MethodAccessFlagEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问标志工具类
 *
 * @author hanjuntao
 * @date 2021/8/13
 */
public class AccessFlagsUtil {
    /**
     * 解析类/接口的详细的访问标志
     *
     * @param accessFlag 访问标志
     * @return 访问标志字符串
     */
    public static String parseClassAccessFlag(int accessFlag) {
        List<String> accessFlags = new ArrayList<>();
        if ((accessFlag & AccessFlagEnum.ACC_PUBLIC.getAccessFlag()) == AccessFlagEnum.ACC_PUBLIC.getAccessFlag()) {
            accessFlags.add(AccessFlagEnum.ACC_PUBLIC.getDesc());
        }
        if ((accessFlag & AccessFlagEnum.ACC_FINAL.getAccessFlag()) == AccessFlagEnum.ACC_FINAL.getAccessFlag()) {
            accessFlags.add(AccessFlagEnum.ACC_FINAL.getDesc());
        }
        if ((accessFlag & AccessFlagEnum.ACC_SUPER.getAccessFlag()) == AccessFlagEnum.ACC_SUPER.getAccessFlag()) {
            accessFlags.add(AccessFlagEnum.ACC_SUPER.getDesc());
        }
        if ((accessFlag & AccessFlagEnum.ACC_INTERFACE.getAccessFlag()) == AccessFlagEnum.ACC_INTERFACE.getAccessFlag()) {
            accessFlags.add(AccessFlagEnum.ACC_INTERFACE.getDesc());
        }
        if ((accessFlag & AccessFlagEnum.ACC_ABSTRACT.getAccessFlag()) == AccessFlagEnum.ACC_ABSTRACT.getAccessFlag()) {
            accessFlags.add(AccessFlagEnum.ACC_ABSTRACT.getDesc());
        }
        if ((accessFlag & AccessFlagEnum.ACC_SYNTHETIC.getAccessFlag()) == AccessFlagEnum.ACC_SYNTHETIC.getAccessFlag()) {
            accessFlags.add(AccessFlagEnum.ACC_SYNTHETIC.getDesc());
        }
        if ((accessFlag & AccessFlagEnum.ACC_ANNOTATION.getAccessFlag()) == AccessFlagEnum.ACC_ANNOTATION.getAccessFlag()) {
            accessFlags.add(AccessFlagEnum.ACC_ANNOTATION.getDesc());
        }
        if ((accessFlag & AccessFlagEnum.ACC_ENUM.getAccessFlag()) == AccessFlagEnum.ACC_ENUM.getAccessFlag()) {
            accessFlags.add(AccessFlagEnum.ACC_ENUM.getDesc());
        }
        StringBuilder sb = new StringBuilder();
        accessFlags.forEach(s -> sb.append(s).append(","));

        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * 解析字段的详细的访问标志
     *
     * @param accessFlag 访问标志
     * @return 访问标志字符串
     */
    public static String parseFieldAccessFlag(int accessFlag) {
        List<String> accessFlags = new ArrayList<>();
        if ((accessFlag & FieldAccessFlagEnum.ACC_PUBLIC.getAccessFlag()) == FieldAccessFlagEnum.ACC_PUBLIC.getAccessFlag()) {
            accessFlags.add(FieldAccessFlagEnum.ACC_PUBLIC.getDesc());
        }

        if ((accessFlag & FieldAccessFlagEnum.ACC_PRIVATE.getAccessFlag()) == FieldAccessFlagEnum.ACC_PRIVATE.getAccessFlag()) {
            accessFlags.add(FieldAccessFlagEnum.ACC_PRIVATE.getDesc());
        }

        if ((accessFlag & FieldAccessFlagEnum.ACC_PROTECTED.getAccessFlag()) == FieldAccessFlagEnum.ACC_PROTECTED.getAccessFlag()) {
            accessFlags.add(FieldAccessFlagEnum.ACC_PROTECTED.getDesc());
        }

        if ((accessFlag & FieldAccessFlagEnum.ACC_STATIC.getAccessFlag()) == FieldAccessFlagEnum.ACC_STATIC.getAccessFlag()) {
            accessFlags.add(FieldAccessFlagEnum.ACC_STATIC.getDesc());
        }

        if ((accessFlag & FieldAccessFlagEnum.ACC_FINAL.getAccessFlag()) == FieldAccessFlagEnum.ACC_FINAL.getAccessFlag()) {
            accessFlags.add(FieldAccessFlagEnum.ACC_FINAL.getDesc());
        }

        if ((accessFlag & FieldAccessFlagEnum.ACC_VOLATILE.getAccessFlag()) == FieldAccessFlagEnum.ACC_VOLATILE.getAccessFlag()) {
            accessFlags.add(FieldAccessFlagEnum.ACC_VOLATILE.getDesc());
        }

        if ((accessFlag & FieldAccessFlagEnum.ACC_TRANSIENT.getAccessFlag()) == FieldAccessFlagEnum.ACC_TRANSIENT.getAccessFlag()) {
            accessFlags.add(FieldAccessFlagEnum.ACC_TRANSIENT.getDesc());
        }

        if ((accessFlag & FieldAccessFlagEnum.ACC_SYNTHETIC.getAccessFlag()) == FieldAccessFlagEnum.ACC_SYNTHETIC.getAccessFlag()) {
            accessFlags.add(FieldAccessFlagEnum.ACC_SYNTHETIC.getDesc());
        }
        if ((accessFlag & FieldAccessFlagEnum.ACC_ENUM.getAccessFlag()) == FieldAccessFlagEnum.ACC_ENUM.getAccessFlag()) {
            accessFlags.add(FieldAccessFlagEnum.ACC_ENUM.getDesc());
        }
        StringBuilder sb = new StringBuilder();
        accessFlags.forEach(s -> sb.append(s).append(","));

        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - 1);
        }
        return sb.toString();
    }


    /**
     * 解析方法的详细的访问标志
     *
     * @param accessFlag 访问标志
     * @return 访问标志字符串
     */
    public static String parseMethodAccessFlag(int accessFlag) {
        List<String> accessFlags = new ArrayList<>();
        if ((accessFlag & MethodAccessFlagEnum.ACC_PUBLIC.getAccessFlag()) == MethodAccessFlagEnum.ACC_PUBLIC.getAccessFlag()) {
            accessFlags.add(MethodAccessFlagEnum.ACC_PUBLIC.getDesc());
        }

        if ((accessFlag & MethodAccessFlagEnum.ACC_PRIVATE.getAccessFlag()) == MethodAccessFlagEnum.ACC_PRIVATE.getAccessFlag()) {
            accessFlags.add(MethodAccessFlagEnum.ACC_PRIVATE.getDesc());
        }

        if ((accessFlag & MethodAccessFlagEnum.ACC_PROTECTED.getAccessFlag()) == MethodAccessFlagEnum.ACC_PROTECTED.getAccessFlag()) {
            accessFlags.add(MethodAccessFlagEnum.ACC_PROTECTED.getDesc());
        }

        if ((accessFlag & MethodAccessFlagEnum.ACC_STATIC.getAccessFlag()) == MethodAccessFlagEnum.ACC_STATIC.getAccessFlag()) {
            accessFlags.add(MethodAccessFlagEnum.ACC_STATIC.getDesc());
        }

        if ((accessFlag & MethodAccessFlagEnum.ACC_FINAL.getAccessFlag()) == MethodAccessFlagEnum.ACC_FINAL.getAccessFlag()) {
            accessFlags.add(MethodAccessFlagEnum.ACC_FINAL.getDesc());
        }

        if ((accessFlag & MethodAccessFlagEnum.ACC_SYNCHRONIZED.getAccessFlag()) == MethodAccessFlagEnum.ACC_SYNCHRONIZED.getAccessFlag()) {
            accessFlags.add(MethodAccessFlagEnum.ACC_SYNCHRONIZED.getDesc());
        }

        if ((accessFlag & MethodAccessFlagEnum.ACC_BRIDGE.getAccessFlag()) == MethodAccessFlagEnum.ACC_BRIDGE.getAccessFlag()) {
            accessFlags.add(MethodAccessFlagEnum.ACC_BRIDGE.getDesc());
        }

        if ((accessFlag & MethodAccessFlagEnum.ACC_VARARGS.getAccessFlag()) == MethodAccessFlagEnum.ACC_VARARGS.getAccessFlag()) {
            accessFlags.add(MethodAccessFlagEnum.ACC_VARARGS.getDesc());
        }

        if ((accessFlag & MethodAccessFlagEnum.ACC_NATIVE.getAccessFlag()) == MethodAccessFlagEnum.ACC_NATIVE.getAccessFlag()) {
            accessFlags.add(MethodAccessFlagEnum.ACC_NATIVE.getDesc());
        }

        if ((accessFlag & MethodAccessFlagEnum.ACC_ABSTRACT.getAccessFlag()) == MethodAccessFlagEnum.ACC_ABSTRACT.getAccessFlag()) {
            accessFlags.add(MethodAccessFlagEnum.ACC_ABSTRACT.getDesc());
        }

        if ((accessFlag & MethodAccessFlagEnum.ACC_STRICT.getAccessFlag()) == MethodAccessFlagEnum.ACC_STRICT.getAccessFlag()) {
            accessFlags.add(MethodAccessFlagEnum.ACC_STRICT.getDesc());
        }

        if ((accessFlag & FieldAccessFlagEnum.ACC_SYNTHETIC.getAccessFlag()) == FieldAccessFlagEnum.ACC_SYNTHETIC.getAccessFlag()) {
            accessFlags.add(FieldAccessFlagEnum.ACC_SYNTHETIC.getDesc());
        }

        StringBuilder sb = new StringBuilder();
        accessFlags.forEach(s -> sb.append(s).append(","));

        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - 1);
        }
        return sb.toString();
    }
}
