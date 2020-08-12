package com.hyl.learnerJVM.classtest;

/**
 * @author hyl
 * @version v1.0: SubClass.java, v 0.1 2020/8/11 11:02 $
 */
public class SubClass extends SuperClass {
    static {
        System.out.println(" sub class init !");
    }

    public void test(){
        System.out.println("test print !");
    }
}
