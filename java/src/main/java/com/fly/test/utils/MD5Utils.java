package com.fly.test.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public final class MD5Utils {

    /**
     * MD5摘要算法
     *
     * 参考文档
     *      大型分布式网站架构设计与实践, P151
     *
     * @param content
     * @return
     * @throws Exception
     */
    public static byte[] stringToMD5(String content) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return md.digest(content.getBytes(StandardCharsets.UTF_8));
    }

    public static void main(String[] args) throws Exception {
        byte[] bytes = stringToMD5("hello,i am chenkangxian,good night!");
        // 字符数组转十六进制字符串
        String hex = HexCodeUtils.bytes2hex(bytes);
        System.err.println(hex);
    }

}
