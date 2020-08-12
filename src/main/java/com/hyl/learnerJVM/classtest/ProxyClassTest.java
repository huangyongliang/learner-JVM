package com.hyl.learnerJVM.classtest;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import sun.misc.ProxyGenerator;

/**
 * @author hyl
 * @version v1.0: ProxyClassTest.java, v 0.1 2020/8/11 13:42 $
 */
public class ProxyClassTest {

    public static void main(String[] args) throws Exception {
         byte[] bytes =ProxyGenerator.generateProxyClass("com.hyl.learnerJVM.classtest.SubClass",SubClass.class.getClasses());

       String path = "C:\\Users\\jack\\Desktop\\SubClass.class";
        Path path1 = Paths.get(path);

        Files.write(path1,bytes,new StandardOpenOption[]{StandardOpenOption.CREATE_NEW,StandardOpenOption.WRITE});
    }

}
