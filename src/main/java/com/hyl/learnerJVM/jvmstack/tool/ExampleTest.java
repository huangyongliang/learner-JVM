package com.hyl.learnerJVM.jvmstack.tool;

/**
 * @author hyl
 * @version v1.0: ExampleTest.java, v 0.1 2020/8/31 16:50 $
 */
public class ExampleTest {
    public static void main(String[] args) throws Throwable {
        System.out.println("main");
        Indify.main("--verify-specifier-count=1",
            /*INDY工具将Example.class转换成等效的class文件存放路径*/
            "--dest=INDY/",
            "--verbose",
            "--expand-properties", "--classpath", "${java.class.path}",
            /*输入class文件Example.class的全路径,然后使用javap打开该文件*/
            "D:\\git\\mybase\\projects\\github\\learner-JVM\\target\\classes\\com\\hyl\\learnerJVM\\jvmstack\\InvokeDynamicTest.class");
        //Example.main();
    }
}
