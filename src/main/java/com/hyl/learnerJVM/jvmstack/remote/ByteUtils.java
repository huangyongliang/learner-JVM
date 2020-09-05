package com.hyl.learnerJVM.jvmstack.remote;

/**
 * Bytes数组处理工具
 *
 * @author hyl
 * @version v1.0: ByteUtils.java, v 0.1 2020/9/4 12:29 $
 */
public abstract class ByteUtils {

    /**
     * 16 进制字节码转为 int
     *
     * @param b 字节码
     * @param start 开始下标
     * @param len 长度
     * @return int 返回值
     */
    public static int bytes2Int(byte[] b, int start, int len) {
        int sum = 0;
        int end = start + len;
        for (int i = start; i < end; i++) {
            int n = ((int) b[i]) & 0xff;
            n <<= (--len) * 8;
            sum = n + sum;
        }
        return sum;
    }

    /**
     * int 转为 16 进制字节码
     *
     * @param value int 数据
     * @param len 字节码长度
     * @return 返回字节码组数
     */
    public static byte[] int2Bytes(int value, int len) {
        byte[] b = new byte[len];
        for (int i = 0; i < len; i++) {
            b[len - i - 1] = (byte) ((value >> 8 * i) & 0xff);
        }
        return b;
    }

    /**
     * 字节码转字符串
     *
     * @param b 字节码数据
     * @param start 开始下标
     * @param len 长度
     * @return 字符串
     */
    public static String bytes2String(byte[] b, int start, int len) {
        return new String(b, start, len);
    }

    /**
     * 字符串转字节码
     *
     * @param str 字符串
     * @return 字节码
     */
    public static byte[] string2Bytes(String str) {
        return str.getBytes();
    }

    public static byte[] bytesReplace(byte[] originalBytes, int offset, int len, byte[] replaceBytes) {
        byte[] newBytes = new byte[originalBytes.length + (replaceBytes.length - len)];
        System.arraycopy(originalBytes, 0, newBytes, 0, offset);
        System.arraycopy(replaceBytes, 0, newBytes, offset, replaceBytes.length);
        System.arraycopy(originalBytes, offset + len, newBytes, offset + replaceBytes.length,
            originalBytes.length - offset - len);
        return newBytes;
    }
}
