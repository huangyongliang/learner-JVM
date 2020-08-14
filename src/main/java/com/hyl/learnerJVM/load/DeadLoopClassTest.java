package com.hyl.learnerJVM.load;

/**
 * @author hyl
 * @version v1.0: DeadLoopClassTest.java, v 0.1 2020/8/13 13:13 $
 */
public class DeadLoopClassTest {

    public static void main(String[] args) {
        Runnable script = () -> {
            System.out.println(Thread.currentThread()+" start");
            DeadLoopClass dlc = new DeadLoopClass();
            System.out.println(Thread.currentThread()+" run over");
        };

        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();

    }

}
