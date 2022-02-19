package com.lotto.lottoapi.entity;

import javax.persistence.Id;

import lombok.Data;

@Data
public class BillEntity {
	@Id
	private String id;
	private String name;
	private String updated;
	private String created;
	private String note;
}
