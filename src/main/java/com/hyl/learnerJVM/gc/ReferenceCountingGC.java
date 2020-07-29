package com.hyl.learnerJVM.gc;

/**
 * 引用计数算法的缺陷
 * <p>
 *     <br>
 *     java虚拟机并没有使用引用计数算法做垃圾回收
 *
 * @author Hyl
 * @version V 0.1
 * @since 0.1 2020-07-03 03:37
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[4 * _1MB];

    public static void main(String[] args) throws Exception {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        System.gc();
        Thread.sleep(1000000);

        objA = new ReferenceCountingGC();

        objB = new ReferenceCountingGC();
        System.gc();
    }

}
