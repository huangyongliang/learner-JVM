package com.hyl.learnerJVM.jvmstack.remote;

/**
 * 执行类加载器
 *
 * @author hyl
 * @version v1.0: HotSwapClassLoader.java, v 0.1 2020/9/4 11:58 $
 */
public class HotSwapClassLoader extends ClassLoader {

    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte) {
        return defineClass(null, classByte, 0, classByte.length);
    }
}
