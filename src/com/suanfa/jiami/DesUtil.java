package com.suanfa.jiami;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DesUtil {
	/**
	 * 生成key值
	 * @throws Exception 
	 */
	public static byte[] init() throws Exception{
		//密钥生成器
		KeyGenerator keyGen=KeyGenerator.getInstance("DES");
		//初始化密钥生成器
		keyGen.init(56);
		//生成密钥
		SecretKey secretKey=keyGen.generateKey();
		return secretKey.getEncoded();
	}
	/**
	 * 加密模式
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 */
	public static byte[] encrypt(byte[] data,byte[] key) throws Exception{
		//恢复密钥
		SecretKey secretKey=new SecretKeySpec(key, "DES");
		//Cipher获取
		Cipher cipher=Cipher.getInstance("DES");
		//根据密钥初始化数据
		cipher.init(Cipher.ENCRYPT_MODE,secretKey);
		byte[] cipherByte=cipher.doFinal(data);
		return cipherByte;
	}
	/**
	 * 解密模式
	 */
	public static byte[] decrypt(byte[] data,byte[] key) throws Exception{
		//恢复密钥
		SecretKey secretKey=new SecretKeySpec(key, "DES");
		//Cipher完成解密工作
		Cipher cipher=Cipher.getInstance("DES");
		//根据密钥初始化数据
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] cipherByte=cipher.doFinal(data);
		return cipherByte;
	}
}
