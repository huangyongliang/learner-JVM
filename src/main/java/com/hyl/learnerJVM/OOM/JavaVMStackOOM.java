package com.hyl.learnerJVM.OOM;

/**
 * VM Args: -Xss2M (max stack space)
 *
 * @author Hyl
 * @version V 0.1
 * @since 0.1 2020-05-25 03:08
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while (true){

        }
    }


    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(this::dontStop);
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();

    }
}
