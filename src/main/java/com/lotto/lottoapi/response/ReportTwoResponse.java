package com.lotto.lottoapi.response;

import java.util.List;

import lombok.Data;

@Data
public class ReportTwoResponse {
	private List<ReportTwoDetail> list;
	private int sum;
	private int over;
}
