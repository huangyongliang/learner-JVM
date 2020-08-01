package com.hyl.learnerJVM.tool;

/**
 * JConsole 死锁测试类
 * <p>
 *
 * @author Hyl
 * @version V 0.1
 * @since 0.1 2020-07-30 13:44
 */
public class MonitoringDeadlockTest {

    static class SynAddRunnable implements Runnable {
        int a, b;

        public SynAddRunnable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            // Integer对象缓冲，会导致不同线程拿到相同的a和b，出现锁的竞争，同时产生死锁
            //      <------------------- 线程 B
            //         等待      加锁
            //          a        b
            //         加锁      等待
            // 线程 A ------------------->
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0 ;i < 100 ;i++){
            new Thread(new SynAddRunnable(1,2)).start();
            new Thread(new SynAddRunnable(2,1)).start();
        }
    }

}
