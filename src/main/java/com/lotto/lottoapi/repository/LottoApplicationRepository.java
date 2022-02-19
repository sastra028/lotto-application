package com.lotto.lottoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lotto.lottoapi.entity.LottoApplicationEntity;
import com.lotto.lottoapi.entity.LottoApplicationEntityKey;

@Repository
public interface LottoApplicationRepository extends JpaRepository<LottoApplicationEntity, LottoApplicationEntityKey> {
	LottoApplicationEntity findByRoundAndBuyerNameAndNumber(String round, String buyerName, String number);
}
