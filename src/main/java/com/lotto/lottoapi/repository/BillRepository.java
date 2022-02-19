package com.lotto.lottoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lotto.lottoapi.entity.BillEntity;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, String> {
	List<BillEntity> findByBuyerName(String buyerName);

	@Query("SELECT max(c.id) FROM BillEntity AS c")
	Long findMaxId();
}
