package com.hyl.learnerJVM.jvmstack;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author hyl
 * @version v1.0: InvokeDynamicTest.java, v 0.1 2020/8/31 15:23 $
 */
public class InvokeDynamicTest {

    public static void testMethod(String s) {
        System.out.println("hello string:" + s);
    }

    public static CallSite BootstrapMethod(MethodHandles.Lookup lookup, String name, MethodType mt) throws Throwable {
        return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest.class, name, mt));
    }

    public static MethodType MT_BootstrapMethod() {
        return MethodType.fromMethodDescriptorString(
            "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType:)Ljava/lang/invoke/CallSite;",
            null);
    }

    public static MethodHandle MH_BootstrapMethod() throws Throwable {
        return MethodHandles.lookup()
            .findStatic(InvokeDynamicTest.class, "BootstrapMethod", MT_BootstrapMethod());
    }

    public static MethodHandle INDY_BootstrapMethod() throws Throwable{
        CallSite cs = (CallSite)MH_BootstrapMethod().invokeWithArguments(MethodHandles.lookup(),"testMethod",MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V",null));
        return cs.dynamicInvoker();
    }

    public static void main(String[] args) throws Throwable {
        INDY_BootstrapMethod().invokeExact("hyl");
    }
}
