package com.hyl.learnerJVM.load;

/**
 * @author hyl
 * @version v1.0: ClinitTestClass.java, v 0.1 2020/8/12 15:23 $
 */
public class ClinitTestClass {

    private static int a = 1;

    private  int b = 2;

    static {
        a = 2;
        // intc  = 4;
         System.out.println(ClinitTestClass.intc);

    }

    private  static int intc =3;

    private int d = 4;

    public ClinitTestClass(int mm){
        intc = mm;
        d = mm;
    }

    public static void main(String[] args) {
        System.out.println(Sun.B);
    }

    static class Parent{
        public static int A = 1;
        static {
            A = 2;
        }

    }

    static class Sun extends Parent{
        public static int B = A;
    }

}
