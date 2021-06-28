package com.applepieme.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 加密工具类
 *
 * @author applepieme
 * @date 2021/6/16 12:08
 */
public class Md5Util {
    private Md5Util() {}

    /**
     * 对用户密码进行加密处理
     *
     * @param password 用户密码
     * @return String
     */
    public static String md5(String password) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                String str = Integer.toHexString(b & 0xFF);
                if (str.length() == 1) {
                    sb.append("0");
                }
                sb.append(str);
            }
            result = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
}
