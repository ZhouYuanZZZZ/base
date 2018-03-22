package com.zy.other;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * MD5 加密
 *
 * @author Peter.liu
 * @since 2014.03.02
 */
public class MD5 extends Object {
    // Null constructor - can't instantiate class
    private MD5() {
    }

    private static final boolean CONST_DEFAULT_LOWER = true;

    private static final char[] CONST_DIGITS_LOWER = { '0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    private static final char[] CONST_DIGITS_UPPER = { '0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    /**
     * 16进制编码
     *
     * @param data
     * @param toDigits
     * @return
     */
    protected static char[] encodeHex(byte[] data, char[] toDigits) {
        int l = data.length;
        char[] out = new char[l << 1];

        int i = 0;
        for (int j = 0; i < l; i++) {
            out[(j++)] = toDigits[((0xF0 & data[i]) >>> 4)];
            out[(j++)] = toDigits[(0xF & data[i])];
        }
        return out;
    }

    /**
     * 16进制编码
     *
     * @param data
     * @return
     */
    public static String encodeHexString(byte[] data) {
        return new String(encodeHex(data));
    }

    /**
     * 16进制编码，默认小写字母输出
     *
     * @param data
     * @return
     */
    public static char[] encodeHex(byte[] data) {
        return encodeHex(data, CONST_DEFAULT_LOWER);
    }

    /**
     * 16进制编码
     *
     * @param data
     * @param toLowerCase
     * @return
     */
    public static char[] encodeHex(byte[] data, boolean toLowerCase) {
        return encodeHex(data, toLowerCase ? CONST_DIGITS_LOWER
                : CONST_DIGITS_UPPER);
    }

    /**
     * 获取字符串的字节数组
     *
     * @param data
     * @return
     */
    public static byte[] getBytesUtf8(String data) {
        if (data == null) {
            return null;
        }
        try {
            return data.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    /**
     * MD5编码
     *
     * @param sInfo
     * @return
     */
    public final static String encode(String sInfo) {
        try {
            // 获取字节数组
            byte[] btInput = getBytesUtf8(sInfo);
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 获得密文
            byte[] md5 = mdInst.digest(btInput);
            // 把密文转换成十六进制的字符串形式
            return encodeHexString(md5);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取登录加密串
     *
     * @param sLoginName
     * @param sLoginPassword
     * @return
     */
    public final static String login(String sLoginName, String sLoginPassword) {
        return login(sLoginName, sLoginPassword, null);
    };

    /**
     * 获取登录加密串
     *
     * @param sLoginName
     * @param sLoginPassword
     * @param sRemainString
     * @return
     */
    public final static String login(String sLoginName, String sLoginPassword,
                                     String sRemainString) {
        String sRemain = "8#d$Up2z";
        if (sRemainString != null && sRemainString.length() > 7) {
            sRemain = sRemainString;
        }
        return encode(sLoginPassword + sLoginName + sRemain);
    };

    public static void main(String[] args) {
        System.out.println(MD5.login("huawei", "123456"));// dc136552e4921a002a9f9e8f2fab9b9f
    }
}
