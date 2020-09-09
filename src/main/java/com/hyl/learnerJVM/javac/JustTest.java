package com.hyl.learnerJVM.javac;

import java.util.List;

/**
 * @author hyl
 * @version v1.0: JustTest.java, v 0.1 2020/9/8 13:12 $
 */
public class JustTest {

    public static void test(List<? extends TestFor> list){

        if (!list.isEmpty()){
            System.out.println(list.toString());
        }

    }


    static class TestFor{

    }

    public static void main(String[] args) throws Exception {

    }

}
