package com.lotto.lottoapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "account")
public class AccountEntity {
	@Id
	private String id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String note;
	private String role;
	private String active;
}
