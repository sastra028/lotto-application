package com.lotto.lottoapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "REWARD")
public class RewardEntity {
	@Id
	private String rewardDate;
	private String twoUp;
	private String twoDown;
	private String three;

}
