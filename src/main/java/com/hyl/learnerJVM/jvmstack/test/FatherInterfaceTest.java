package com.hyl.learnerJVM.jvmstack.test;

/**
 * @author hyl
 * @version v1.0: FatherInterfaceTest.java, v 0.1 2020/8/29 18:28 $
 */
public class FatherInterfaceTest {

    public static void main(String[] args) {
        FatherIntf fatherIntf = new FatherImpl();
        fatherIntf.sayHello();
    }
}
