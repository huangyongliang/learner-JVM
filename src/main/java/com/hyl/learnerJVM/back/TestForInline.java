package com.hyl.learnerJVM.back;

/**
 * @author hyl
 * @version v1.0: TestForInline.java, v 0.1 2020/9/13 22:25 $
 */
public class TestForInline {

    static class B{
        int value;
        final int get(){
            return value;
        }
    }

    public static void main(String[] args) {
        B b = new B();
        b.value = 100;
   
        int y = b.get();
        y =y;

        System.out.println(y);

    }


}
