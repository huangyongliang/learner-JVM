package com.hyl.learnerJVM.OOM;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * 1.7 VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M <br>
 * 1.8 VM Args: -Xmx20M -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M -XX:CompressedClassSpaceSize=10m<br>
 *
 * @author Hyl
 * @version V 0.1
 * @since 0.1 2020-05-25 04:33
 */
public class DirectMemoryOOM {

    private static final int _1MB = 5*1024*1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }

}
