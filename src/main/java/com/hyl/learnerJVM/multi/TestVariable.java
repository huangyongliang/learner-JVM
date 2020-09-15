package com.hyl.learnerJVM.multi;

/**
 * 多线程数据读写异常
 *
 * @author hyl
 * @version v1.0: TestVariable.java, v 0.1 2020/9/15 14:24 $
 */
public class TestVariable {

    static int TEST_INT = 0;

    final static  int COUNT = 10000;

    final static int THREAD_SIZE = 20;

    public static void main(String[] args) throws InterruptedException {

        // 锁对象
      //  Object lock = new Object();

        Runnable runnable = () -> {
            for (int i = 0; i < COUNT; i++) {
                // 加锁处理
                // synchronized (lock){
                //     TEST_INT ++;
                // }
                TEST_INT ++;
            }
        };

        Thread[] threads = new Thread[THREAD_SIZE];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(runnable);
        }

        for (Thread thread : threads){
            thread.start();
        }

        for (Thread thread:threads){
            thread.join();
        }

        System.out.println("end: "+TEST_INT);

    }

}
