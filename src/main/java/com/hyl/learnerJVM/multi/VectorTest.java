package com.hyl.learnerJVM.multi;

import java.util.Vector;

/**
 * Vector线程安全测试
 *
 * @author hyl
 * @version v1.0: VectorTest.java, v 0.1 2020/9/17 0:20 $
 */
public class VectorTest {

    private static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) {

        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread removeThread = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }
            });

            Thread printThread = new Thread(() -> {
                for (Integer integer : vector) {
                    System.out.println(integer);
                }
            });

            removeThread.start();
            printThread.start();

            //不要同时产生过多的线程，否则会导致操作系统假死
            while (Thread.activeCount() > 20)
                ;

        }

    }
}
