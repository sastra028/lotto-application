package com.lotto.lottoapi.response;

import lombok.Data;

@Data
public class LottoTwoListNewResponse {
	private String buyerName;
	private LottoTwoListNewResponse2 list;
}
