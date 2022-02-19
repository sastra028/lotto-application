package com.lotto.lottoapi.entity;

import javax.persistence.Id;

import lombok.Data;

@Data
public class RewardEntity {
	@Id
	private String rewardDate;
	private String twoUp;
	private String twoDown;
	private String three;
	
}
