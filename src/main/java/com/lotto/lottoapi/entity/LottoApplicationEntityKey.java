package com.lotto.lottoapi.entity;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class LottoApplicationEntityKey implements Serializable {
	private String id;
	private String number;
	private String type;
	private String nature;
	private String buyerName;
	private String round;

	public LottoApplicationEntityKey() {
		super();
	}

	public LottoApplicationEntityKey(String id, String number, String type, String nature, String buyerName,
			String round) {
		super();
		this.id = id;
		this.number = number;
		this.type = type;
		this.nature = nature;
		this.buyerName = buyerName;
		this.round = round;
	}

}
