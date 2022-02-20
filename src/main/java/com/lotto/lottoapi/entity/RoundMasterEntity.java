package com.lotto.lottoapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ROUND_MASTER")
public class RoundMasterEntity {
	@Id
	private String round;
	private String active;
}
