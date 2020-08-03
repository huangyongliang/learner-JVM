package com.hyl.learnerJVM.allocation;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap测试实验
 * <p>
 *
 * @author Hyl
 * @version V 0.1
 * @since 0.1 2020-08-03 09:37
 */
public class HashMapTestForCreate {

    private static final long count =5000000;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Map<Long,Long> map = new HashMap<>();

        for (long i = 1;i <= count;i++){
            map.put(i,i);
        }

        long insertEnd = System.currentTimeMillis();
        System.out.println("插入时间："+(insertEnd-start)+"ms");
        Long aLong = map.get(count);

        long getEnd = System.currentTimeMillis();
        System.out.println("插入时间："+(getEnd-insertEnd)+"ms");

    }


}
