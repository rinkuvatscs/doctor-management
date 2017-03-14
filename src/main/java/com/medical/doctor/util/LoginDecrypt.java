package com.medical.doctor.util;

import java.util.Base64;

import javax.crypto.Cipher;

public class LoginDecrypt extends AbstractEncryptDecrypt {

	public static String decrypt(String strToDecrypt, String secret) {
		try {
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(
					strToDecrypt)));
		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}
}
