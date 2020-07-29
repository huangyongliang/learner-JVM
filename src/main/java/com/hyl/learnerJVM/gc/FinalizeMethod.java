package com.hyl.learnerJVM.gc;

/**
 * finalize执行测试
 * <p>
 *
 * @author Hyl
 * @version V 0.1
 * @since 0.1 2020-07-03 04:57
 */
public class FinalizeMethod {

    public static FinalizeMethod Fin = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize run !");
        // 通过finalize救赎一次，仅能一次
        FinalizeMethod.Fin = this;
        // 任何异常会被忽略掉
        throw new RuntimeException("我就是想试试看");
    }

    public void isAlive() {
        System.out.println("I am alive");
    }

    public static void main(String[] args) throws Exception {
        Fin = new FinalizeMethod();
        // 第一次自我毁灭
        Fin = null;
        System.gc();
        Thread.sleep(500);
        if (Fin != null) {
            Fin.isAlive();
        } else {
            System.out.println("I am dead!");
        }

        // 第二次自我毁灭
        Fin = null;
        System.gc();
        Thread.sleep(500);
        if (Fin != null) {
            Fin.isAlive();
        } else {
            System.out.println("I am dead!");
        }

    }
}
