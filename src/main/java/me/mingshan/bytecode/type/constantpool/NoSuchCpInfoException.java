package me.mingshan.bytecode.type.constantpool;

/**
 * @author hanjuntao
 * @date 2021/8/13
 */
public class NoSuchCpInfoException extends Exception {
    public NoSuchCpInfoException(Exception e) {
        super(e);
    }
}
