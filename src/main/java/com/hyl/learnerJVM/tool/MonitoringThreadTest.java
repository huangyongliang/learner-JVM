package com.hyl.learnerJVM.tool;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * JConsole 线程测试类
 * <p>
 *
 * @author Hyl
 * @version V 0.1
 * @since 0.1 2020-07-30 13:20
 */
public class MonitoringThreadTest {

    /**
     * 线程死循环
     */
    public static void createBusyThread(){
        Thread thread = new Thread(() -> {
            while (true)
                ;
        },"testBusyThread");
        thread.start();
    }

    /**
     * 线程锁等待
     * @param lock
     */
    public static void createLockThread(final Object lock){
        Thread thread = new Thread(() -> {
            synchronized (lock){
                try {
                    lock.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"testLockThread");

        thread.start();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        Object object = new Object();
        createLockThread(object);

    }

}
