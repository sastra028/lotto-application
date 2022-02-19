package com.lotto.lottoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lotto.lottoapi.entity.LottoApplicationEntity;

@Repository
public interface LottoApplicationRepository extends JpaRepository<LottoApplicationEntity, String> {
	List<LottoApplicationEntity> findByRoundAndBuyerNameAndNumber(String round, String buyerName, String number);

	LottoApplicationEntity findFirstByRoundAndBuyerNameAndNumberAndTypeAndSubType(String round, String buyerName, String number, String type, String subType);
}