package com.lotto.lottoapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "lotto_limit")
public class LottoLimitEntity {
	@Id
	private String id;
	private String round;
	private String sellerName;
	private String number;
	private String type;
	private String subtype;
	private int limitPrice;
}
