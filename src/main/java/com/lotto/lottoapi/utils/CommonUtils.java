package com.lotto.lottoapi.utils;

import java.util.Base64;

import org.apache.commons.lang3.StringUtils;

public class CommonUtils {
	public static String encodePassword(String username, String password) {
		String encodeUsername = Base64.getEncoder().encodeToString(username.getBytes());
		String encodePassword = Base64.getEncoder().encodeToString(password.getBytes());
		System.out.println(encodeUsername);
		System.out.println(encodePassword);
		String userPass = encodeUsername + "." + encodePassword;
		String encode = Base64.getEncoder().encodeToString(userPass.getBytes());

		return encode;

	}

	public static boolean passwordMatch(String usernameLogin, String passwordLogin, String password) {
		String decodedUser = "";
		String decodedPass = "";

		if (StringUtils.isBlank(usernameLogin) || StringUtils.isBlank(usernameLogin)) {
			return false;
		}

		try {
			byte[] decoded = Base64.getDecoder().decode(password);
			String decodedUP = new String(decoded);
			System.out.println(decodedUP);
			String[] decodeSplit = decodedUP.split("\\.");
			byte[] decodedU = Base64.getDecoder().decode(decodeSplit[0]);
			byte[] decodedP = Base64.getDecoder().decode(decodeSplit[1]);
			decodedUser = new String(decodedU);
			decodedPass = new String(decodedP);
		} catch (Exception e) {
			e.printStackTrace();
		}		

		return (usernameLogin.equals(decodedUser) && passwordLogin.equals(decodedPass));

	}
}
