package com.hyl.learnerJVM.jvmstack.dynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @author hyl
 * @version v1.0: Son.java, v 0.1 2020/9/1 12:51 $
 */
public class Son extends Father {
    @Override
    void think() {
        MethodType mt = MethodType.methodType(void.class);
        // try {
        //     MethodHandle mh = lookup().findSpecial(GrandFather.class,"think",mt,getClass());
        //     mh.invoke(this);
        // } catch (Throwable e) {
        //     e.printStackTrace();
        // }

        try {
            Field lookupImpl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
            lookupImpl.setAccessible(true);
            MethodHandle mh =((MethodHandles.Lookup)lookupImpl.get(null)) .findSpecial(GrandFather.class,"think",mt,GrandFather.class);
            mh.invoke(this);
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Son().think();
    }
}
