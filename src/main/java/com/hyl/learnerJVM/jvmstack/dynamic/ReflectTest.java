package com.hyl.learnerJVM.jvmstack.dynamic;

import java.lang.reflect.Field;

/**
 * @author hyl
 * @version v1.0: ReflectTest.java, v 0.1 2020/9/1 13:42 $
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.hyl.learnerJVM.jvmstack.dynamic.Boy");
        Boy boy = new Boy();
        boy.setName("fake");

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        Object o = name.get(boy);

        System.out.println(o);

    }
}
