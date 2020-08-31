package com.hyl.learnerJVM.jvmstack.test;

/**
 * @author hyl
 * @version v1.0: FieldHasNoPolymorphic.java, v 0.1 2020/8/28 17:53 $
 */
public class FieldHasNoPolymorphic {
    public static void main(String[] args) {
        Father guy = new Son();
        System.out.println("I am guy, i have $"+guy.money);
        guy.showMeTheMoney();
    }
}
