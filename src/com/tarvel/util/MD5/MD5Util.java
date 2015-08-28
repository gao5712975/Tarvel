package com.tarvel.util.MD5;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 * Created by Yuan on 2015/7/11 0011.
 */
public class MD5Util {

    public static String getPasswordWithBase64(String password){
        String pwd = "gaoyuan" + password + "weixiao";
        return Base64.encodeToString(pwd.getBytes());
    }

    public static String getPasswordWithHex(String password){
        String pwd = "gaoyuan" + password + "weixiao";
        return Hex.encodeToString(pwd.getBytes());
    }

    public static String getPasswordWithMD5(String password){
        String pwd = "gaoyuan" + password + "weixiao";
        return new Md5Hash(pwd).toString();
    }

    public static String getPasswordWithSHA256(String password){
        String pwd = "gaoyuan" + password + "weixiao";
        return new Sha256Hash(pwd).toString();
    }
}
