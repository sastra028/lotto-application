package com.lotto.lottoapi.response;

import java.util.List;

import lombok.Data;

@Data
public class LottoThreeListResponse {
	private String main;
	private List<LottoThreeListSubResponse> list;
}
