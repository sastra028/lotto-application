package com.lotto.lottoapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "lotto_transaction")
public class LottoTransactionEntity {
	@Id
	private String id;
	private String name;
	private String updated;
	private String created;
	private String note;
}
