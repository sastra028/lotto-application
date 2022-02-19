package com.lotto.lottoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lotto.lottoapi.entity.LottoEntity;

@Repository
public interface LottoRepository extends JpaRepository<LottoEntity, String> {
	List<LottoEntity> findByType(String type);
	
	@Query("SELECT c.buyerName FROM LottoEntity AS c GROUP BY c.buyerName ORDER BY c.buyerName DESC")
	List<String> findGroupByBuyerName();
	
	List<LottoEntity> findByBuyerName(String buyerName);
	List<LottoEntity> findByBuyerNameAndType(String buyerName, String type);
}
