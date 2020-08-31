package com.hyl.learnerJVM.jvmstack.test;

/**
 * @author hyl
 * @version v1.0: Father.java, v 0.1 2020/8/28 17:52 $
 */
public class Father {
    public int money = 1;

    public Father(){
        money = 2;
        showMeTheMoney();
    }

    public void showMeTheMoney(){
        System.out.println("I am Father, i have $"+money);
    }
}
