package com.lotto.lottoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lotto.lottoapi.entity.RoundMasterEntity;

@Repository
public interface RoundMasterRepository extends JpaRepository<RoundMasterEntity, String> {
	List<RoundMasterEntity> findByActive(String active);
}
