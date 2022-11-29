package me.mingshan.bytecode.md.asm;

import java.util.List;

/**
 * @author hanjuntao
 * @date 2021/10/29
 */
public class EntityInfo {
    private String className;
    private List<FieldInfo> fields;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<FieldInfo> getFields() {
        return fields;
    }

    public void setFields(List<FieldInfo> fields) {
        this.fields = fields;
    }

    public static class FieldInfo {
        private String name;
        private Class<?> classType;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Class<?> getClassType() {
            return classType;
        }

        public void setClassType(Class<?> classType) {
            this.classType = classType;
        }
    }
}
