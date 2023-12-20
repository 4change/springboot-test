package com.fly.test.utils;

import java.util.Random;

public final class HexCodeUtils {

    /**
     * 将字节数组转换为十六进制进制值的字符串， 和public static byte[] hexStr2ByteArr(String strIn) 互为可逆的转换过程
     *
     * @param arrB 需要转换的byte数组
     * @return 转换后的字符串
     * @throws Exception  本方法不处理任何异常，所有异常全部抛出
     */
    public static String bytes2hex(byte[] arrB) {
        int iLen = arrB.length;
        // 每个byte用2个字符才能表示，所以字符串的长度是数组长度的2倍
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            // 把负数转换为正数
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            // 小于0F的数需要在前面补0
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    /**
     * 将表示16进制值的字符串转换为byte数组，和public static String byteArr2HexStr(byte[] arrB)
     * 互为可逆的转换过程
     * @param strIn 需要转换的字符串
     * @return 转换后的byte数组
     */
    public static byte[] hex2bytes(String strIn) {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;
        // 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0 ; i < 1000; i++) {
            String s = getRandomCharOfLength(8);
            byte[] bytes = hex2bytes(s);
            String s1 = bytes2hex(bytes);
            System.out.println(s + "------------" + s1);
        }
    }

    public static String getRandomCharOfLength(int length) {
        StringBuilder sb = new StringBuilder();
        String s = "0123456789abcdef";
        char[] c = s.toCharArray();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(c[random.nextInt(c.length)]);
        }
        return sb.toString();
    }

}
