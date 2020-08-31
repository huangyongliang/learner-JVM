package com.hyl.learnerJVM.jvmstack.test;

/**
 * @author hyl
 * @version v1.0: Son.java, v 0.1 2020/8/28 17:52 $
 */
public class Son extends Father{
    public int money = 3;

    public Son(){
        money = 4;
        showMeTheMoney();
    }
    @Override
    public void showMeTheMoney(){
        System.out.println("I am Son, i have $"+money);
    }
}
