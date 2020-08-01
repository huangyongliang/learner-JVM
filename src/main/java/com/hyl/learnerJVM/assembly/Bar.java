package com.hyl.learnerJVM.assembly;

/**
 * 反汇编测试
 * <p>
 *
 * @author Hyl
 * @version V 0.1
 * @since 0.1 2020-08-01 10:42
 */
public class Bar {
    int a = 1;
    static int b = 2;

    public int sum(int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        new Bar().sum(3);
    }

}