package me.mingshan.bytecode.type.constantpool;

import me.mingshan.bytecode.type.CpInfo;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class CpInfoFactory {
    private static final Map<Byte, Class<? extends CpInfo>> CP_INFO_MAP = new HashMap<>();

    static {
        CP_INFO_MAP.put(CpInfoTagEnum.CONSTANT_Class.getValue(), CONSTANT_Class_info.class);
        CP_INFO_MAP.put(CpInfoTagEnum.CONSTANT_String.getValue(), CONSTANT_String_info.class);
        CP_INFO_MAP.put(CpInfoTagEnum.CONSTANT_Utf8.getValue(), CONSTANT_Utf8_info.class);
        CP_INFO_MAP.put(CpInfoTagEnum.CONSTANT_NameAndType.getValue(), CONSTANT_NameAndType_info.class);
        CP_INFO_MAP.put(CpInfoTagEnum.CONSTANT_Double.getValue(), CONSTANT_Double_info.class);
        CP_INFO_MAP.put(CpInfoTagEnum.CONSTANT_Long.getValue(), CONSTANT_Long_info.class);
        CP_INFO_MAP.put(CpInfoTagEnum.CONSTANT_Float.getValue(), CONSTANT_Float_info.class);
        CP_INFO_MAP.put(CpInfoTagEnum.CONSTANT_Integer.getValue(), CONSTANT_Integer_info.class);
        CP_INFO_MAP.put(CpInfoTagEnum.CONSTANT_Fieldref.getValue(), CONSTANT_Fieldref_info.class);
        CP_INFO_MAP.put(CpInfoTagEnum.CONSTANT_Methodref.getValue(), CONSTANT_Methodref_info.class);
        CP_INFO_MAP.put(CpInfoTagEnum.CONSTANT_InterfaceMethodref.getValue(), CONSTANT_InterfaceMethodref_info.class);
        CP_INFO_MAP.put(CpInfoTagEnum.CONSTANT_MethodHandle.getValue(), CONSTANT_MethodHandle_info.class);
        CP_INFO_MAP.put(CpInfoTagEnum.CONSTANT_MethodType.getValue(), CONSTANT_MethodType_info.class);
        CP_INFO_MAP.put(CpInfoTagEnum.CONSTANT_InvokeDynamic.getValue(), CONSTANT_InvokeDynamic_info.class);
        CP_INFO_MAP.put(CpInfoTagEnum.CONSTANT_Module.getValue(), CONSTANT_Module_info.class);
        CP_INFO_MAP.put(CpInfoTagEnum.CONSTANT_Package.getValue(), CONSTANT_Package_info.class);
    }

    public static CpInfo getCpInfo(byte tag) throws NoSuchCpInfoException {
        Object[] params;
        Constructor<? extends CpInfo> con;

        try {
            Class<? extends CpInfo> aClass = CP_INFO_MAP.get(tag);
            Class<?>[] paramTypes = {CpInfoTagEnum.class};
            params = new Object[]{CpInfoTagEnum.valueOf2(tag)};
            con = aClass.getConstructor(paramTypes);
            return con.newInstance(params);
        } catch (Exception e) {
            throw new NoSuchCpInfoException(e);
        }
    }
}
