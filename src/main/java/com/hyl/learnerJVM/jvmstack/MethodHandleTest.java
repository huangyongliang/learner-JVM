package com.hyl.learnerJVM.jvmstack;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * MethodHandle基础用法演示
 *
 * @author hyl
 * @version v1.0: MethodHandleTest.java, v 0.1 2020/8/31 13:22 $
 */
public class MethodHandleTest {

    static class ClassA{
        public void println(String s){
            System.out.println("hyl "+s);
        }
        public void printlnAdd(String s){
            System.out.println(s+"  hyl");
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out :new ClassA();
        getPrintlnMH(obj).invokeExact("hello world");
    }

    private static MethodHandle getPrintlnMH(Object receiver) throws Throwable{
        MethodType mt = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup().findVirtual(receiver.getClass(),"println",mt).bindTo(receiver);
    }

}
