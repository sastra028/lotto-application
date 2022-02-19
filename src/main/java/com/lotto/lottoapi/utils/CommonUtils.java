package com.lotto.lottoapi.utils;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class CommonUtils {
	public static String encodePassword(String username, String password) {
		String encodeUsername = Base64.getEncoder().encodeToString(username.getBytes());
		String encodePassword = Base64.getEncoder().encodeToString(password.getBytes());
//		System.out.println(encodeUsername);
//		System.out.println(encodePassword);
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
//			System.out.println(decodedUP);
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

	public static List<String> getTote(String input) {
		List<String> result = new ArrayList<>();
		
		if (StringUtils.isBlank(input)) {
			return result;
		}
		
		if (input.length() != 3) {
			return result;
		}
		
		String one = input.substring(0, 1);
		String two = input.substring(1, 2);
		String three = input.substring(2, 3);

		result.add(one + two + three);
		result.add(one + three + two);
		result.add(two + one + three);
		result.add(two + three + one);
		result.add(three + one + two);
		result.add(three + two + one);
		return result;
	}
}
