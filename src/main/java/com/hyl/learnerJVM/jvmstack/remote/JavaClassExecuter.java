package com.hyl.learnerJVM.jvmstack.remote;

import java.lang.reflect.Method;

/**
 * Javaclass 执行工具
 *
 * @author hyl
 * @version v1.0: JavaclassExecuter.java, v 0.1 2020/9/4 13:38 $
 */
public class JavaClassExecuter {

    /**
     * 执行外部传过来的代表一个 Java 类的 Byte 数组<br>
     *     将输入类的 byte 数组中代表 java.lang.System 的 CONSTANT_Utf8_info 常量修改为劫持后的 HackSystem 类<br>
     *         执行方法为该类的 static main(String[] args) 方法，输出结果为该类向 System.out/err 输出的信息
     * @param classByte 代表一个 Java 类的 Byte 数组
     * @return 执行结果
     */
    public static String execute(byte[] classByte){
        HackSystem.clearBuffer();
        ClassModifier cm = new ClassModifier(classByte);
        byte[] modifierByte = cm.modifyUTF8Constant("java/lang/System","com/hyl/learnerJVM/jvmstack/remote/HackSystem");

        HotSwapClassLoader loader = new HotSwapClassLoader();
        Class clazz = loader.loadByte(modifierByte);
        try {
            Method method = clazz.getMethod("main",new Class[]{String[].class});
            method.invoke(null,new String[]{null});
        }catch (Throwable e){
            e.printStackTrace(HackSystem.out);
        }
        return HackSystem.getBufferString();
    }
}
