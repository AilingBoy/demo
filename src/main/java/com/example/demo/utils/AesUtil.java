package com.example.demo.utils;

import com.example.demo.result.JsonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * @author AilingBoy
 * https://github.com/AilingBoy
 * @version 1.0
 * @date 2020/5/16 18:59
 */
public class AesUtil {

    /**
     * 基础加密
     */
    public static final String BASE_KEY = "0000000000000000";
    //参数分别代表 算法名称/加密模式/数据填充方式
    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";

    public static String encrypt(String content,String key) throws Exception{
        return doEncrypt(content,key);
    }

    public static String decrypt(String content,String key) throws Exception{
        return doDecrypt(content,key);
    }

    private static String doEncrypt(String content, String key) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(content.getBytes());
        keyGenerator.init(128, secureRandom);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"));
        byte[] b = cipher.doFinal(content.getBytes("utf-8"));
        return Base64.encodeBase64String(b);
    }

    private static String doDecrypt(String content, String key)  throws Exception{
        KeyGenerator keyGenerator= KeyGenerator.getInstance("AES");
        SecureRandom secureRandom= SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(content.getBytes());
        keyGenerator.init(128, secureRandom);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"));
        byte[] encryptBytes = Base64.decodeBase64(content);
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        return new String(decryptBytes);
    }

    /**
     * 加密数据
     *
     * @param jsonResult
     * @param aesKey
     * @return
     */
    public static String encryptReturnData(JsonResult jsonResult, String aesKey) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(jsonResult);
        return AesUtil.encrypt(content, aesKey);
    }

}
