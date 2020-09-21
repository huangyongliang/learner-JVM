package com.hyl.learnerJVM.multi;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hyl
 * @version v1.0: AtomicTest.java, v 0.1 2020/9/17 15:07 $
 */
public class AtomicTest {

    public static AtomicInteger race = new AtomicInteger(0);

    public static void increase(){
        race.incrementAndGet();
    }

    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) {

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 100000; j++) {
                    increase();
                }
            });

            threads[i].start();
        }

        while (Thread.activeCount()>2)
            Thread.yield();

        System.out.println(race);
    }


    public String concat(String s1,String s2,String s3){
        return s1+s2+s3;
    }

}
