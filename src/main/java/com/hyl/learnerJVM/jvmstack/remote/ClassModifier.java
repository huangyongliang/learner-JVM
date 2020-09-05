package com.hyl.learnerJVM.jvmstack.remote;

/**
 * Class文件修改器 (JDK 8)
 *
 * @author hyl
 * @version v1.0: ClassModifier.java, v 0.1 2020/9/4 12:04 $
 */
public class ClassModifier {

    /**
     * Class 文件中常量池的起始偏移量
     */
    private static final int CONSTANT_POOL_COUNT_INDEX = 8;
    /**
     * CONSTANT_Utf8_info 常量的 tag 标志
     */
    private static final int CONSTANT_Utf8_info = 1;
    /**
     * 常量池中 11 种常量所占的长度，CONSTANT_Utf8_info 型常量除外，因为它不是定长的，JDK 8 是14种
     */
    private static final int[] CONSTANT_ITEM_LENGTH = {-1, -1, -1, 5, 5, 9, 9, 3, 3, 5, 5, 5, 5, -1, -1, 4, 3, -1, 5};

    private static final int u1 = 1;
    private static final int u2 = 2;

    /**
     * Class 文件字节码
     */
    private byte[] classByte;

    public ClassModifier(byte[] classByte) {
        this.classByte = classByte;
    }

    /**
     * 修改常量池中 CONSTANT_Utf8_info 常量的内容
     *
     * @param oldStr 修改前的字符串
     * @param newStr 修改后的字符串
     * @return 修改结果
     */
    public byte[] modifyUTF8Constant(String oldStr, String newStr) {

        int cpc = getConstantPoolCount();
        int offset = CONSTANT_POOL_COUNT_INDEX + u2;

        for (int i = 0; i < cpc; i++) {

            int tag = ByteUtils.bytes2Int(classByte, offset, u1);
            if (tag == CONSTANT_Utf8_info) {
                int len = ByteUtils.bytes2Int(classByte, offset + u1, u2);
                offset += (u1 + u2);
                String str = ByteUtils.bytes2String(classByte, offset, len);
                // 寻找目标字符串
                if (str.equalsIgnoreCase(oldStr)) {
                    byte[] strBytes = ByteUtils.string2Bytes(newStr);
                    byte[] strLen = ByteUtils.int2Bytes(newStr.length(), u2);
                    // 替换原来长度
                    classByte = ByteUtils.bytesReplace(classByte, offset - u2, u2, strLen);
                    // 替换字节码
                    classByte = ByteUtils.bytesReplace(classByte, offset, len, strBytes);
                    return classByte;
                } else {
                    // 不是目标字符串，累加字符串长度的偏移量
                    offset += len;
                }
            } else {
                // 跳过当前常量，累加偏移量
                offset += CONSTANT_ITEM_LENGTH[tag];
            }
        }
        return classByte;
    }

    /**
     * 获取常量池中常量的数量
     *
     * @return 常量池数量
     */
    public int getConstantPoolCount() {
        return ByteUtils.bytes2Int(classByte, CONSTANT_POOL_COUNT_INDEX, u2);
    }

}
