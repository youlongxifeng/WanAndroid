package com.shehuan.wanandroid.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/**
 * @Author: xiezhenggen
 * @Time: 2018 2018/11/30 8:54
 * @description: （二进制转换工具类）
 */
public class ByteUtil {

    /**
     * 将2个byte数组进行拼接
     */
    public static byte[] addBytes(byte[] data1, byte[] data2) {
        byte[] data3 = new byte[data1.length + data2.length];
        System.arraycopy(data1, 0, data3, 0, data1.length);
        System.arraycopy(data2, 0, data3, data1.length, data2.length);
        return data3;
    }

    /**
     * 将3个byte数组进行拼接
     */
    public static byte[] addBytes(byte[] data1, byte[] data2, byte[] data3) {
        byte[] data4 = new byte[data1.length + data2.length + data3.length];
        System.arraycopy(data1, 0, data4, 0, data1.length);
        System.arraycopy(data2, 0, data4, data1.length, data2.length);
        System.arraycopy(data3, 0, data4, data1.length + data2.length, data3.length);
        return data4;
    }

    /**
     * int转byte{}
     */
    public static byte[] intToBytes(int value, ByteOrder mode) {
        byte[] src = new byte[4];
        if (mode == ByteOrder.LITTLE_ENDIAN) {
            src[3] = (byte) ((value >> 24) & 0xFF);
            src[2] = (byte) ((value >> 16) & 0xFF);
            src[1] = (byte) ((value >> 8) & 0xFF);
            src[0] = (byte) (value & 0xFF);
        } else {
            src[0] = (byte) ((value >> 24) & 0xFF);
            src[1] = (byte) ((value >> 16) & 0xFF);
            src[2] = (byte) ((value >> 8) & 0xFF);
            src[3] = (byte) (value & 0xFF);
        }
        return src;
    }


    /**
     * 16进制表示的字符串转换为字节数组
     *
     * @param s 16进制表示的字符串
     * @return byte[] 字节数组
     */
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] b = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            // 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个字节
            b[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
                    .digit(s.charAt(i + 1), 16));
        }
        return b;
    }


    /**
     * byte数组中取int数值，本方法适用于(低位在前，高位在后)的顺序，和和intToBytes（）配套使用
     *
     * @param src    byte数组
     * @param offset 从数组的第offset位开始
     * @return int数值
     */
    public static int bytesToInt(byte[] src, int offset) {
        int value;
        value = (int) ((src[offset] & 0xFF)
                | ((src[offset + 1] & 0xFF) << 8)
                | ((src[offset + 2] & 0xFF) << 16)
                | ((src[offset + 3] & 0xFF) << 24));
        return value;
    }

    /**
     * byte数组中取int数值，本方法适用于(低位在后，高位在前)的顺序。和intToBytes2（）配套使用
     */
    public static int bytesToInt2(byte[] src, int offset) {
        int value;
        value = (int) (((src[offset] & 0xFF) << 24)
                | ((src[offset + 1] & 0xFF) << 16)
                | ((src[offset + 2] & 0xFF) << 8)
                | (src[offset + 3] & 0xFF));
        return value;
    }

    /**
     * 将int数值转换为占四个字节的byte数组，本方法适用于(低位在前，高位在后)的顺序。 和
     bytesToInt（）配套使用
     *
     * @param value 要转换的int值
     * @return byte数组
     */
    public static byte[] intToBytes(int value) {
        byte[] src = new byte[4];
        src[3] = (byte) ((value >> 24) & 0xFF);
        src[2] = (byte) ((value >> 16) & 0xFF);
        src[1] = (byte) ((value >> 8) & 0xFF);
        src[0] = (byte) (value & 0xFF);
        return src;
    }

    /**
     * 将int数值转换为占四个字节的byte数组，本方法适用于(高位在前，低位在后)的顺序。  和
     bytesToInt2（）配套使用
     */
    public static byte[] intToBytes2(int value) {
        byte[] src = new byte[4];
        src[0] = (byte) ((value >> 24) & 0xFF);
        src[1] = (byte) ((value >> 16) & 0xFF);
        src[2] = (byte) ((value >> 8) & 0xFF);
        src[3] = (byte) (value & 0xFF);
        return src;
    }

    /**
     * 将字节转换为二进制字符串
     *
     * @param bytes 字节数组
     * @return 二进制字符串
     */
    public static String byteToBit(byte... bytes) {
        StringBuffer sb = new StringBuffer();
        int z, len;
        String str;
        for (int w = 0; w < bytes.length; w++) {
            z = bytes[w];
            z |= 256;
            str = Integer.toBinaryString(z);
            len = str.length();
            sb.append(str.substring(len - 8, len));
        }
        return sb.toString();
    }

    /**
     * 字节数组转为普通字符串（ASCII对应的字符）
     *
     * @param bytearray byte[]
     * @return String
     */
    public static String byte2String(byte[] bytearray) {
        String result = "";
        char temp;

        int length = bytearray.length;
        for (int i = 0; i < length; i++) {
            temp = (char) bytearray[i];
            result += temp;
        }
        return result;
    }

    /**
     * 二进制字符串转十进制
     *
     * @param binary 二进制字符串
     * @return 十进制数值
     */
    public static int binaryToAlgorism(String binary) {
        int max = binary.length();
        int result = 0;
        for (int i = max; i > 0; i--) {
            char c = binary.charAt(i - 1);
            int algorism = c - '0';
            result += Math.pow(2, max - i) * algorism;
        }
        return result;
    }

    /**
     * 字节数组转换为十六进制字符串
     *
     * @param b byte[] 需要转换的字节数组
     * @return String 十六进制字符串
     */
    public static String byte2hex(byte b[]) {
        if (b == null) {
            throw new IllegalArgumentException(
                    "Argument b ( byte array ) is null! ");
        }
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xff);
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }

    /**
     * 十六进制字符串转换十进制
     *
     * @param hex 十六进制字符串
     * @return 十进制数值
     */
    public static int hexStringToAlgorism(String hex) {
        hex = hex.toUpperCase();
        int max = hex.length();
        int result = 0;
        for (int i = max; i > 0; i--) {
            char c = hex.charAt(i - 1);
            int algorism = 0;
            if (c >= '0' && c <= '9') {
                algorism = c - '0';
            } else {
                algorism = c - 55;
            }
            result += Math.pow(16, max - i) * algorism;
        }
        return result;
    }

    /**
     * 字符串转换成十六进制字符串
     *
     * @param str 待转换的ASCII字符串
     * @return String 每个Byte之间空格分隔，如: [61 6C 6B]
     */
    public static String str2HexStr(String str) {

        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;

        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    /**
     * 16进制转换成字符串
     *
     * @param hexStr
     * @return
     */
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;

        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }

    /**
     * 重写了Inpustream 中的skip(long n) 方法，
     * 将数据流中起始的n 个字节跳过
     */
    public static long skipBytesFromStream(InputStream inputStream, long n) {
        long remaining = n;
        // SKIP_BUFFER_SIZE is used to determine the size of skipBuffer
        int SKIP_BUFFER_SIZE = 2048;
        // skipBuffer is initialized in skip(long), if needed.
        byte[] skipBuffer = null;
        int nr = 0;
        if (skipBuffer == null) {
            skipBuffer = new byte[SKIP_BUFFER_SIZE];
        }
        byte[] localSkipBuffer = skipBuffer;
        if (n <= 0) {
            return 0;
        }
        while (remaining > 0) {
            try {
                nr = inputStream.read(localSkipBuffer, 0,
                        (int) Math.min(SKIP_BUFFER_SIZE, remaining));
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nr < 0) {
                break;
            }
            remaining -= nr;
        }
        return n - remaining;
    }
}
