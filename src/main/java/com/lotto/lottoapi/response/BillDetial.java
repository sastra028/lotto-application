package com.lotto.lottoapi.response;

import lombok.Data;

@Data
public class BillDetial {
	private String id;
	private String number;
	private int price;
	private boolean prize;
}
