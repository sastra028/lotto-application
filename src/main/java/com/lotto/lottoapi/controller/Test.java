package com.lotto.lottoapi.controller;

import java.util.Base64;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String originalInput = "test input";
//		String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes())  + "-123789";
//		String encodedString2 = Base64.getEncoder().encodeToString(encodedString.getBytes());
//		System.out.println(encodedString2);
//		byte[] decodedBytes = Base64.getDecoder().decode(encodedString2);
//		String decodedString = new String(decodedBytes);
//		System.out.println(decodedString);
//		byte[] decodedBytes2 = Base64.getDecoder().decode(decodedString);
//		String decodedString2 = new String(decodedBytes2);
//		System.out.println(decodedString2);
//		
//		
		String username = "sastraasdasdfsadf";
		String password = "P@ssw12rd";
		String encodeUsername = Base64.getEncoder().encodeToString(username.getBytes());
		String encodePassword = Base64.getEncoder().encodeToString(password.getBytes());
		System.out.println(encodeUsername);
		System.out.println(encodePassword);
		String userPass = encodeUsername + "." + encodePassword;
		String encode = Base64.getEncoder().encodeToString(userPass.getBytes() );
				
		byte[] decoded = Base64.getDecoder().decode(encode);
		String decodedUP = new String(decoded);
		System.out.println(decodedUP);
		String[] decodeSplit = decodedUP.split("\\.");
		byte[] decodedU = Base64.getDecoder().decode(decodeSplit[0]);
		byte[] decodedP = Base64.getDecoder().decode(decodeSplit[1]);
		String decodedUser = new String(decodedU);
		String decodedPass = new String(decodedP);

		System.out.println(decodedUser);
		System.out.println(decodedPass);
	}

}