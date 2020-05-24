package com.hyl.learnerJVM.OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M <br>
 * 常量池<br>
 * 1.7之前是在方法区，在永久代<br>
 *<br>
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=10M; support was removed in 8.0<br>
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=10M; support was removed in 8.0<br>
 *<br>
 * 1.8在heap中开辟了一个区域<br>
 *<br>
 * VM Args : -Xms2m -Xmx2m -XX:+HeapDumpOnOutOfMemoryError
 * @author Hyl
 * @version V 0.1
 * @since 0.1 2020-05-25 03:32
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {

        //使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<>();
        //10MB的PermSize在integer范围内足够产生OOM了
        int i = 0;

        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }

}
