package me.mingshan.bytecode.md.jdk;

/**
 * @author hanjuntao
 * @date 2023/2/8
 */
public class TestServiceImpl implements TestService {
    @Override
    public void hello() {
        System.out.println("say hello");
    }
}
