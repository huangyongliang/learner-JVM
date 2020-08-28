package com.hyl.learnerJVM.jvmstack;

/**
 * 字段不参与多态
 *
 * @author hyl
 * @version v1.0: FieldHasNoPolymorphic.java, v 0.1 2020/8/28 17:12 $
 */
public class FieldHasNoPolymorphic {
    static class Father{
        public int money = 1;

        public Father(){
            money = 2;
            showMeTheMoney();
        }

        public void showMeTheMoney(){
            System.out.println("I am Father, i have $"+money);
        }
    }

    static class Son extends Father{
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

    public static void main(String[] args) {
        Father guy = new Son();
        System.out.println("I am guy, i have $"+guy.money);
    }


}
