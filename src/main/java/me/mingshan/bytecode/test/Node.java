package me.mingshan.bytecode.test;

public class Node {
    private Node prev;

    final Node predecessor() throws NullPointerException {
        if (this.prev == null)
            throw new NullPointerException();
        else
            return this.prev;
    }
}
