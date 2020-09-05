package com.hyl.learnerJVM.jvmstack.remote;

import java.io.ByteArrayOutputStream;
import java.io.Console;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import java.nio.channels.Channel;

import java.util.Properties;

import sun.reflect.CallerSensitive;

/**
 * <h>为 JavaClass 劫持 java.lang.System 提供支持</h>
 * <br>
 * <br>
 * 出了 out 和 err 外，其余的都直接转发 System 处理
 *
 * @author hyl
 * @version v1.0: HackSystem.java, v 0.1 2020/9/4 13:42 $
 */
public class HackSystem {

    public final static InputStream in = System.in;

    private static ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    public final static PrintStream out = new PrintStream(buffer);

    public final static PrintStream err = out;


    public static String getBufferString(){
        return buffer.toString();
    }

    public static void clearBuffer(){
        buffer.reset();
    }


    public static void setIn(InputStream in) {
        System.setIn(in);
    }

    public static void setOut(PrintStream out) {
        System.setOut(out);
    }

    public static void setErr(PrintStream err) {
        System.setErr(err);
    }

    public static Console console() {
        return System.console();
    }

    public static Channel inheritedChannel() throws IOException {
        return System.inheritedChannel();
    }

    public static void setSecurityManager(final SecurityManager s) {
        System.setSecurityManager(s);
    }

    public static SecurityManager getSecurityManager() {
        return System.getSecurityManager();
    }

    public static native long currentTimeMillis();

    public static native long nanoTime();

    public static native void arraycopy(Object src, int srcPos, Object dest, int destPos, int length);

    public static native int identityHashCode(Object x);

    public static Properties getProperties() {
        return System.getProperties();
    }

    public static String lineSeparator() {
        return System.lineSeparator();
    }

    public static void setProperties(Properties props) {
        System.setProperties(props);
    }

    public static String getProperty(String key) {
        return System.getProperty(key);
    }

    public static String getProperty(String key, String def) {
        return System.getProperty(key, def);
    }

    public static String setProperty(String key, String value) {
        return System.setProperty(key, value);
    }

    public static String clearProperty(String key) {
        return System.clearProperty(key);
    }

    public static String getenv(String name) {
        return System.getenv(name);
    }

    public static java.util.Map<String, String> getenv() {
        return System.getenv();
    }

    public static void exit(int status) {
        System.exit(status);
    }

    public static void gc() {
        System.gc();
    }

    public static void runFinalization() {
        System.runFinalization();
    }

    @Deprecated
    public static void runFinalizersOnExit(boolean value) {
        System.runFinalizersOnExit(value);
    }

    @CallerSensitive
    public static void load(String filename) {
        System.load(filename);
    }

    @CallerSensitive
    public static void loadLibrary(String libname) {
        System.loadLibrary(libname);
    }

    public static native String mapLibraryName(String libname);

}
