package com.hyl.learnerJVM.allocation;

/**
 * 分配测试
 * <p>
 * vm 参数：-Xms15M -Xmx15M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution -XX:+UseSerialGC
 *
 * @author Hyl
 * @version V 0.1
 * @since 0.1 2020-07-29 09:49
 */
public class TestAllocation {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        // 防止虚拟机自动新建的对象干扰测试
        System.gc();

        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];
        // allocation4 = new byte[_1MB / 4];

        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
        // allocation4 = new byte[6 * _1MB];

        // allocation3 = new byte[4 * _1MB];

    }

}
