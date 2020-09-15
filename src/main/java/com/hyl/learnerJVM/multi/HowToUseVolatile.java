package com.hyl.learnerJVM.multi;

/**
 * @author hyl
 * @version v1.0: HowToUseVolatile.java, v 0.1 2020/9/15 16:28 $
 */
public class HowToUseVolatile {


    static volatile boolean flag = true;

    public static void main(String[] args) throws  Exception{

        Runnable runnable = ()->{
            int count = 0;
            while (flag){
                try {
                    Thread.sleep(200);
                    count++;
                    System.out.println(Thread.currentThread().getName()+": wait "+count +"*200 ms");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread[] threads = new Thread[20];

        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(runnable);
        }

        for (Thread thread:threads){
            thread.start();
        }

        Thread.sleep(10000);

        flag = false;

        for (Thread thread:threads){
            thread.join();
        }

    }




}
