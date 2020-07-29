package com.hyl.learnerJVM.gc;

/**
 * G1测试类
 * <p>
 *
 * @author Hyl
 * @version V 0.1
 * @since 0.1 2020-07-09 15:29
 */
public class GarbageFirstTest {
    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[4 * _1MB];

    public static void main(String[] args) {
        GarbageFirstTest garbageFirstTest = new GarbageFirstTest();
        GarbageFirstTest garbageFirstTestA = new GarbageFirstTest();

        garbageFirstTest = null;
        garbageFirstTestA = null;
        System.gc();
    }
}
