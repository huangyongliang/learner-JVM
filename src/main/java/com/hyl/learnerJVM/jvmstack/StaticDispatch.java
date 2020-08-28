package com.hyl.learnerJVM.jvmstack;

import java.util.Random;

/**
 * 静态分派
 *
 * @author hyl
 * @version v1.0: StaticDispatch.java, v 0.1 2020/8/19 17:10 $
 */
public class StaticDispatch {

    static abstract class Human{

    }

    static class Man extends Human{

    }

    static class Woman extends Human{

    }

    public void sayHello(Human human){
        System.out.println(" hello human ");
    }

    public void sayHello(Man man){
        System.out.println(" hello man ");
    }

    public void sayHello(Woman woman){
        System.out.println(" hello woman ");
    }

    public static void main(String[] args) {
        // Human man = new Man();
        // Human woman = new Woman();
        Human human =(new Random()).nextBoolean()? new Man():new Woman();
        StaticDispatch staticDispatch = new StaticDispatch();
        // staticDispatch.sayHello(man);
        // staticDispatch.sayHello(woman);
        if (human instanceof Man){
            staticDispatch.sayHello((Man) human);
        }
        if (human instanceof Woman){
            staticDispatch.sayHello((Woman) human);
        }

    }

}
