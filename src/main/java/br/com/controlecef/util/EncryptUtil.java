package br.com.controlecef.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {

	public static final String ALGORITHM_MD5 = "MD5";
	public static final String APPLICATION_SALT = "HdyshnQWN#n3144@sfafqldo9TQPO3nH5dame652$$910*m311!21235mdajGGdf$fey5td%hdna";

	public static String encrypt(String msg) {
		String aux = msg;
		try {
			String toEncrypt = msg + APPLICATION_SALT;
			MessageDigest md = MessageDigest.getInstance(ALGORITHM_MD5);
			md.update(toEncrypt.getBytes());

			byte[] byteData = md.digest();

			// convert the byte to hex format
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}

			aux = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return aux;
	}
}
