package com.suanfa.jiami;

public class TestEnDecrypt {
	public static void main(String[] args) throws Exception {
		String info="yzhniubi";
		
		/* Test DES */
		//生成密钥
		byte[] deskey=DesUtil.init();
		System.out.println("DES >>>deskey "+BytesToHex.fromBytesToHex(deskey));
		//加密密钥
		byte[] desResult=DesUtil.encrypt(info.getBytes(), deskey);
		System.out.println("DES >>>encrypt key "+BytesToHex.fromBytesToHex(desResult));
		//解密
		byte[] desPlain=DesUtil.decrypt(desResult, deskey);
		System.out.println("DES >>>decrypt key "+new String(desPlain));
		
		/* Test 3DES */
		byte[] trideskey=TripleDESUtil.initKey();
		System.out.println("3DES >>3DESkey "+BytesToHex.fromBytesToHex(trideskey));
		
		byte[] tridesResult=TripleDESUtil.encrypt(info.getBytes(), trideskey);
		System.out.println("3DES >>>encrypt 3deskey "+BytesToHex.fromBytesToHex(tridesResult));
		byte[] tridesPlain=TripleDESUtil.decrypt(tridesResult, trideskey);
		System.out.println("3DES >>>decrypt key "+new String(tridesPlain));
	}
}
