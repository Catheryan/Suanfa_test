package com.suanfa.jiami;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class TripleDESUtil {
	/**
	 * 生成密钥的形式
	 * @throws Exception 
	 */
	public static byte[] initKey() throws Exception{
		KeyGenerator kenGen =KeyGenerator.getInstance("Desede");
		kenGen.init(168);
		SecretKey secretKey=kenGen.generateKey();
		return secretKey.getEncoded();
	}
	/**
	 * 加密的形式
	 * @throws Exception 
	 * 
	 */
	public static byte[] encrypt(byte[] data,byte[] key) throws Exception{
		SecretKey secretKey=new SecretKeySpec(key, "DESede");
		Cipher cipher=Cipher.getInstance("DESede");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptByte=cipher.doFinal(data);
		return encryptByte;
		
	}
	/**
	 * 解密的形式
	 */
	public static byte[] decrypt(byte[] data,byte[] key)throws Exception{
		SecretKey secretKey=new SecretKeySpec(key, "DESede");
		Cipher cipher=Cipher.getInstance("DESede");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptByte =cipher.doFinal(data);
		return decryptByte;
	}
}
