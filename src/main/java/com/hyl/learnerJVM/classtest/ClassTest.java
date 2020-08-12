package com.hyl.learnerJVM.classtest;

/**
 * class测试类
 *
 * @author hyl
 * @version v1.0: ClassTest.java, v 0.1 2020/8/7 8:03 $
 */
public class ClassTest {

    private static  long n =10;

    public long inLong() {

        long m = n + 1;
        return m;
    }

    public void hyl(){
        synchronized (this){
            System.out.println(1-0.9);
        }
    }

    public static void main(String[] args) {

        synchronized (ClassTest.class){
            int[] m = new int[10];
            int mLen = m.length;
        }


    }
}
