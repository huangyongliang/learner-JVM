package com.hyl.learnerJVM.OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args : -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author Hyl
 * @version V 0.1
 * @since 0.1 2020-05-25 02:06
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true){
            list.add(new OOMObject());
        }
    }

}
