package com.hyl.learnerJVM.javac;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hyl
 * @version v1.0: Generics.java, v 0.1 2020/9/7 23:49 $
 */
public class Generics <T>{

    public void generics(T t){
        List<T> list = new ArrayList<>();
        list.add(t);

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
    }

    /**
     * 协变
     */
    public void covariant(){


        Object[] array = new String[10];
        // 会报错
        array[0] = 10;

        ArrayList thing = new ArrayList();
        // 不会报错
        thing.add(Integer.valueOf(1));
        thing.add("hello world");

    }


    public void rawType(){
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        ArrayList list;
        list = integers;
        list = strings;

    }

    public static void forEach(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        int sum =0;
        for (int i: list){
            sum +=i;
        }
        System.out.println(sum);
    }


    public static void autoFacade(){
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(c == d);
        System.out.println( e == f);
        System.out.println( c == ( a + b));
        System.out.println( c.equals( a + b));
        System.out.println( g == (a+b));
        System.out.println( g.equals(a + b));

    }


    public static void main(String[] args) {

        autoFacade();

    }



}
