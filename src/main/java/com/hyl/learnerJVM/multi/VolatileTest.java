package com.hyl.learnerJVM.multi;

/**
 * volatile 变量自增运算测试
 *
 * @author hyl
 * @version v1.0: VolatileTest.java, v 0.1 2020/9/15 14:59 $
 */
public class VolatileTest {

    public static volatile int race = 0;

    public static void increase(){
        race ++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {

        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i <THREADS_COUNT; i++) {

            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        // 等待所有累加线程都结束
        // while (Thread.activeCount()>2)
        //     Thread.yield();
        //
        // 等到全部执行完

        for (Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(race);

    }



}
