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

    public U2 getStartPc() {
        return startPc;
    }

    public void setStartPc(U2 startPc) {
        this.startPc = startPc;
    }

    public U2 getEndPc() {
        return endPc;
    }

    public void setEndPc(U2 endPc) {
        this.endPc = endPc;
    }

    public U2 getHandlerPc() {
        return handlerPc;
    }

    public void setHandlerPc(U2 handlerPc) {
        this.handlerPc = handlerPc;
    }

    public U2 getCatchType() {
        return catchType;
    }

    public void setCatchType(U2 catchType) {
        this.catchType = catchType;
    }
}
