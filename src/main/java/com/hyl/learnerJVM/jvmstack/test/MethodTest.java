package com.hyl.learnerJVM.jvmstack.test;

/**
 * @author hyl
 * @version v1.0: MethodTest.java, v 0.1 2020/9/1 23:43 $
 */
public class MethodTest {

    @FunctionalInterface
     interface TestInterface{
        void test();
    }

    public static void test( TestInterface testInterface){
        testInterface.test();
    }


    public static void main(String[] args) {
        TestInterface test = ()->{};
        MethodTest.test(test);
    }
}
