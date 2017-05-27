package com.common.utils;

import java.security.MessageDigest;

public class MD5 {
	/**
	 * MD5 的加密方法
	 * @param src 要加密的字符串
	 * @return 加密后的字符串
	 */
	public static String getMD5(String src){
		char hexDigits[] = {'0', '1' ,'2' ,'3' ,'4' ,'5' ,'6' ,'7' ,'8' ,'9' ,
							'a' ,'b' ,'c' ,'d' ,'e' ,'f'};
		try {
			byte[] strTemp = src.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char[] str = new char[j*2];
			int k = 0;
			for(int i = 0; i < j; i++){
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
}
