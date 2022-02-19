package com.lotto.lottoapi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "lotto-application")
@IdClass(LottoApplicationEntityKey.class)
public class LottoApplicationEntity {

	@Id
	private String id;

	@Id
	private String round;
	
	@Id
	private String number;

	@Id
	private String type;

	@Id
	private String nature;
	
	@Id
	private String buyerName;

	private int price;


	private Date created;

	private String createBy;

}
