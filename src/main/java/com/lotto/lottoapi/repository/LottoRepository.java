package com.lotto.lottoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lotto.lottoapi.entity.LottoEntity;

@Repository
public interface LottoRepository extends JpaRepository<LottoEntity, String> {
	List<LottoEntity> findByType(String type);
//	List<LottoEntity> findByTypeGroupByBuyerName(String type);
}
