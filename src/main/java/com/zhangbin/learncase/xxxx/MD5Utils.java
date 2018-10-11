package com.zhangbin.learncase.xxxx;


import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author
 * @Type MD5Utils
 * @Desc MD5加密
 * @date 2015年10月28日
 * @Version V1.0
 */
public class MD5Utils {
    public static String encryptMD5(String data) throws NoSuchAlgorithmException {
        byte[] md5Byte = encryptMD5(data.getBytes(Charset.forName("UTF-8")));
        return byte2hex(md5Byte);
    }

    /**
     * md5加密
     *
     * @param data
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static byte[] encryptMD5(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return md.digest(data);
    }

    /**
     * 二进制转换为大写的十六进制
     *
     * @param bytes
     * @return
     */
    public static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }
}
