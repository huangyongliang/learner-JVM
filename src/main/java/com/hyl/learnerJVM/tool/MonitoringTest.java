package com.hyl.learnerJVM.tool;

import java.util.ArrayList;
import java.util.List;

/**
 * JConsole测试
 * <p>
 * vm args:-Xms100m -Xmx100m -XX:+UseSerialGC
 * @author Hyl
 * @version V 0.1
 * @since 0.1 2020-07-30 11:32
 */
public class MonitoringTest {

    static class OOMObject {
        public byte[] placeHolder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {

        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            // 稍作延迟，令监视曲线的变化更加明显。
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
    }

}
