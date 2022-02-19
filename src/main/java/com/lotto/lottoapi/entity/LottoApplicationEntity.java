package com.lotto.lottoapi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "lotto_application")
public class LottoApplicationEntity {

	@Id
	private String id;

	private String round;

	private String number;

	private String type;

	private String subType;

	private String buyerName;
	
	private String sellerName;

	private int price;

	private Date created;

	private String createBy;

}
