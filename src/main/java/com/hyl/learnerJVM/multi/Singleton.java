package com.hyl.learnerJVM.multi;

/**
 * DCL单例测试
 * <p>
 *
 * @author Hyl
 * @version V 0.1
 * @since 0.1 2020-09-15 17:56
 */
public class Singleton {
    private volatile static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }

}
