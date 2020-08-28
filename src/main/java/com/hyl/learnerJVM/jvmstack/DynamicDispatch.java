package com.hyl.learnerJVM.jvmstack;

/**
 * 动态分派
 *
 * @author hyl
 * @version v1.0: DynamicDispatch.java, v 0.1 2020/8/24 15:37 $
 */
public class DynamicDispatch {

    static  abstract class Human{
        /**
         * say hello method
         */
        protected abstract void sayHello();
        }


    static  class Man extends DynamicDispatch.Human {
         @Override
         protected void sayHello() {
             System.out.println(" man\tsay\thello ");
         }
     }

     static class Woman extends DynamicDispatch.Human{
         @Override
         protected void sayHello() {
             System.out.println(" woman\tsay\thello ");
         }
     }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();

        man.sayHello();
        woman.sayHello();

        man = new Woman();
        man.sayHello();

    }
}
