package com.lotto.lottoapi.request;

import lombok.Data;

@Data
public class AccountRegisterRequest {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String note;
	private String role;
}
