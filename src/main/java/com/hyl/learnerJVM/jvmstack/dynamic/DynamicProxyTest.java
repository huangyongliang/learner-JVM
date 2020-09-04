package com.hyl.learnerJVM.jvmstack.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hyl
 * @version v1.0: DynamicProxyTest.java, v 0.1 2020/9/3 19:45 $
 */
public class DynamicProxyTest {

    interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {

        @Override
        public void sayHello() {
            System.out.println("hello world");
        }
    }

    static class DynamicProxy implements InvocationHandler {

        Object originalObject;

        Object bind(Object originalObj) {
            this.originalObject = originalObj;
            return Proxy.newProxyInstance(originalObj.getClass()
                .getClassLoader(), originalObj.getClass()
                .getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            return method.invoke(originalObject, args);
        }
    }

    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        IHello hello =(IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();


    }

}
