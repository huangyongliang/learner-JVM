package com.hyl.learnerJVM.OOM;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * 1.7 VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M<br>
 * <br>
 * 1.8 VM Args: -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M <br>
 *
 * @author Hyl
 * @version V 0.1
 * @since 0.1 2020-05-25 04:12
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {

        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(
                (MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(objects, args));
            enhancer.create();
        }
    }

    static class OOMObject {

    }

}
