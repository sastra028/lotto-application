package com.lotto.lottoapi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "bill")
public class BillEntity {
	@Id
	private String buyerName;
	private long id;
	private String sellerName;
	private Date updated;
	private Date created;
	private String note;
}
