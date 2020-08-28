package com.hyl.learnerJVM.jvmstack;

/**
 * 局部变量表测试
 *
 * @author hyl
 * @version v1.0: VariableTest.java, v 0.1 2020/8/17 19:35 $
 */
public class VariableTest {

    private long long1;
    private int int1;
    private double double1;


    public VariableTest(){
        long1 = 1L;
        int1 = 1;
        double1 = 1;
    }

    public void add1Method(){
        long1++;
        int1++;
        double1++;
    }

    public void add2Method(){
         long long2=1;
         int int2=1;
         double double2=1;

         long2++;
         int2++;
         double2++;

    }

    private static  int i;

    public static void main(String[] args) {

        {
            byte[] placeholder = new byte[64 * 1024 * 1024];

        }

        VariableTest variableTest = new VariableTest();
        variableTest.add2Method();
        int i;
        // i++;
        VariableTest.i++;
        System.out.println(VariableTest.i);
        System.gc();
    }

}
