package com.hyl.learnerJVM.load;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载器与 instanceof 关键词演示
 *
 * @author hyl
 * @version v1.0: ClassLoaderTest.java, v 0.1 2020/8/13 13:30 $
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try {

                    String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null){
                        return super.loadClass(name);
                    }
                    byte[] b =new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);

                }catch (IOException e){
                    throw  new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("com.hyl.learnerJVM.load.ClassLoaderTest").newInstance();

        System.out.println( obj.getClass());
        System.out.println( obj instanceof com.hyl.learnerJVM.load.ClassLoaderTest);

        ClassLoader myLoader2 = ClassLoader.getSystemClassLoader();

        Object obj2 = myLoader2.loadClass("com.hyl.learnerJVM.load.ClassLoaderTest").newInstance();

        System.out.println( obj2.getClass());
        System.out.println( obj2 instanceof com.hyl.learnerJVM.load.ClassLoaderTest);

        Object obj3 =ClassLoaderTest.class.getClassLoader().loadClass("com.hyl.learnerJVM.load.ClassLoaderTest").newInstance();

        System.out.println( obj3.getClass());
        System.out.println( obj3 instanceof com.hyl.learnerJVM.load.ClassLoaderTest);
    }
}
