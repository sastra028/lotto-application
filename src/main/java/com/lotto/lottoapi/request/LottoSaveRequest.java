package com.lotto.lottoapi.request;

import lombok.Data;

@Data
public class LottoSaveRequest {
	private String number;
	private String priceA;
	private String priceB;
	private String buyerName;
	private String sellerName;
}
