package com.lotto.lottoapi.response;

import lombok.Data;

@Data
public class ReportTwoDetail {
	private String number;
	private int up;
	private int down;
	private int upLimit;
	private int downLimit;
	private boolean upMax;
	private boolean downMax;
}
