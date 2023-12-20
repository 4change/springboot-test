package com.fly.test.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public final class BASE64Utils {

    public static String byte2base64(byte[] bytes) {
        return new BASE64Encoder().encode(bytes);
    }

    public static byte[] base642byte(String base64) throws IOException {
        return new BASE64Decoder().decodeBuffer(base64);
    }

}
