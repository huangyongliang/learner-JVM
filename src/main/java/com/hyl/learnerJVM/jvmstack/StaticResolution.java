package com.hyl.learnerJVM.jvmstack;

/**
 * @author hyl
 * @version v1.0: StaticResolution.java, v 0.1 2020/8/19 16:21 $
 */
public class StaticResolution {
    public static void sayHello(){
        System.out.println(" hello world ");
    }

    public final void sayNo(){
        System.out.println(" No ");
    }
    public static void main(String[] args) {
        // invokestatic  #6                  // Method sayHello:()V
        StaticResolution.sayHello();
        StaticResolution staticResolution = new StaticResolution();
        // invokevirtual #9                  // Method sayNo:()V
        staticResolution.sayNo();
    }
}
