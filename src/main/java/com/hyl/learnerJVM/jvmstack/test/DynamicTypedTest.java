package com.hyl.learnerJVM.jvmstack.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态类型语音测试
 *
 * @author hyl
 * @version v1.0: DynamicTypedTest.java, v 0.1 2020/8/30 21:11 $
 */
public class DynamicTypedTest {

    public static void main(String[] args) {

        int [][][] array = new int[1][0][-2];

        Arrays.stream(array).forEach(System.out::println);

        List<String> list = new ArrayList<>();

        list.sort((a,b)-> 0);
    }
}
