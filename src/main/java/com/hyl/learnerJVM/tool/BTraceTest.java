package com.hyl.learnerJVM.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BTrace测试类
 * <p>
 *
 * @author Hyl
 * @version V 0.1
 * @since 0.1 2020-07-30 15:30
 */
public class BTraceTest {

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws IOException {
        BTraceTest bTraceTest = new BTraceTest();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            br.readLine();
            int a = (int) Math.round(Math.random() * 1000);
            int b = (int) Math.round(Math.random() * 1000);
            System.out.println(bTraceTest.add(a, b));
        }
    }
}
/**

 import com.sun.btrace.annotations.*;
 import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class TracingScript {

    @OnMethod(
        clazz = "com.hyl.learnerJVM.tool.BTraceTest",
        method = "add",
        location = @Location(Kind.RETURN)
    )


    public static void func(@Self com.hyl.learnerJVM.tool.BTraceTest instance, int a, int b,@Return int result ){

        println("调用堆栈：");
        jstack();
        println(strcat("方法参数A:",str(a)));
        println(strcat("方法参数B:",str(b)));
        println(strcat("方法结果:",str(result)));

    }

}
 **/