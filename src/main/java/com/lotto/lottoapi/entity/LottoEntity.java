package com.lotto.lottoapi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "lotto")
public class LottoEntity {
	@Id
	private String id;

	private String number;

	private String type;
	
	private int priceA;
	
	private int priceB;

	private String buyerName;

	private Date created;

	private String createBy;
}
