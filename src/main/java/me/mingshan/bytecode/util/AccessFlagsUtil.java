package me.mingshan.bytecode.util;

import me.mingshan.bytecode.type.AccessFlagEnum;
import me.mingshan.bytecode.type.FieldAccessFlagEnum;

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
}
