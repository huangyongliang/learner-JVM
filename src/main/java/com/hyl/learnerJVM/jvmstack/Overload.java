package com.hyl.learnerJVM.jvmstack;

import java.io.Serializable;

/**
 * 重载方法匹配优先级
 *
 * @author hyl
 * @version v1.0: Overload.java, v 0.1 2020/8/20 11:15 $
 */
public class Overload {
    public static void sayHello(Object arg){
        System.out.println(" hello Object ");
    }
    public static void sayHello(int arg){
        System.out.println(" hello int "+arg);
    }
    public static void sayHello(long arg){
        System.out.println(" hello long "+arg);
    }
    public static void sayHello(Character arg){
        System.out.println(" hello Character ");
    }
    // public static void sayHello(Integer arg){
    //     System.out.println(" hello Integer ");
    // }
    // public static void sayHello(char arg){
    //     System.out.println(" hello char ");
    // }
    public static void sayHello(char...  arg){
        System.out.println(" hello char ");
    }
    public static void sayHello(Serializable arg){
        System.out.println(" hello Serializable ");
    }

    public static void sayHello(Comparable arg){
        System.out.println(" hello Comparable ");
    }

    public static void sayHello(String arg){
        System.out.println(" hello String ");
    }
    public static void sayHello(byte arg){
        System.out.println(" hello byte ");
    }
    public static void sayHello(short arg){
        System.out.println(" hello short ");
    }
    // public static void sayHello(float arg){
    //     System.out.println(" hello float "+arg);
    // }
    // public static void sayHello(double arg){
    //     System.out.println(" hello double "+arg);
    // }
    public static void main(String[] args) {
        sayHello('a');
        System.out.println(111);
        System.out.println(111);
    }
}
