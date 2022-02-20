package com.lotto.lottoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lotto.lottoapi.entity.LottoLimitEntity;

@Repository
public interface LottoLimitRepository extends JpaRepository<LottoLimitEntity, String> {
	List<LottoLimitEntity> findByRoundAndSellerName(String round, String buyerName);
}
