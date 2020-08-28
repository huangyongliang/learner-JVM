package com.hyl.learnerJVM.jvmstack;

/**
 * 递归编译测试
 *
 * @author hyl
 * @version v1.0: Recursion.java, v 0.1 2020/8/15 22:25 $
 */
public class Recursion {
    public void testR(){
        testR();;
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        recursion.testR();
    }
}
