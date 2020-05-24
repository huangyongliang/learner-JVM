package com.hyl.learnerJVM.OOM;

import org.junit.jupiter.api.Test;

/**
 * @author Hyl
 * @version V 0.1
 * @since 0.1 2020-05-25 03:55
 */
public class RuntimeConstantPoolOOMTest {

    @Test
    public void test(){
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern()==str1);


        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern()==str2);
    }

}
