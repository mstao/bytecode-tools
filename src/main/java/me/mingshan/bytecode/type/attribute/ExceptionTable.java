package me.mingshan.bytecode.type.attribute;

import me.mingshan.bytecode.type.U2;

/**
 * @author hanjuntao
 * @date 2021/8/14
 */
public class ExceptionTable {
    private U2 startPc;
    private U2 endPc;
    private U2 handlerPc;
    private U2 catchType;
}
