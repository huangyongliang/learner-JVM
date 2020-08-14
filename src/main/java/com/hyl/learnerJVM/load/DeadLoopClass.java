package com.hyl.learnerJVM.load;

/**
 * @author hyl
 * @version v1.0: DeadLoopClass.java, v 0.1 2020/8/13 13:07 $
 */
public class DeadLoopClass {

    static {
        if (true){
            System.out.println(Thread.currentThread()+" init DeadLoopClass");
            while (true){

            }
        }
    }

}
