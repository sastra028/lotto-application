package com.lotto.lottoapi.response;

import java.util.List;

import lombok.Data;

@Data
public class BillListResponse {
	private String billId;
	private String name;
	private String update;
	
	private int twoUpTotal;
	private int twoUpPrize;
	
	private int twoDownTotal;
	private int twoDownPrize;
	
	private int threeDirectTotal;
	private int threeDirectPrize;
	
	private int threeToteTotal;
	private int threeTotePrize;
	
	private int priceTotal;
	private int prizeTotal;
	
	private List<BillDetial> listTwoUp;
	private List<BillDetial> listTwoDown;
	private List<BillDetial> listThreeDirect;
	private List<BillDetial> listThreeTote;
}
