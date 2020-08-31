package com.hyl.learnerJVM.jvmstack;

/**
 * 单分派、多分派
 *
 * @author hyl
 * @version v1.0: Dispatch.java, v 0.1 2020/8/29 17:26 $
 */
public class Dispatch {

    static class QQ{}

    static class _360{}

    public static class Father{

        public void hardChoice(QQ arg){
            System.out.println("father choose qq");
        }

        public void hardChoice(_360 arg){
            System.out.println("father choose 360");
        }
    }

    public static class Son extends Father{

        @Override
        public void hardChoice(QQ arg) {
            System.out.println("son choose qq");
        }

        @Override
        public void hardChoice(_360 arg) {
            System.out.println("son choose 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }

}
