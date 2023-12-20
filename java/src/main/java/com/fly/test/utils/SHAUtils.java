package com.fly.test.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class SHAUtils {

    /**
     * SHA1摘要算法
     *
     * 参考文档
     *      大型分布式网站架构设计与实现　P151
     *
     * @param content
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static byte[] string2SHA1(String content) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] bytes = md.digest(content.getBytes("utf8"));
        return bytes;
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] bytes = string2SHA1("hello,i am chenkangxian,good night!");
        // 字符数组转十六进制字符串
        String hex = HexCodeUtils.bytes2hex(bytes);
        System.err.println(hex);
    }

}
