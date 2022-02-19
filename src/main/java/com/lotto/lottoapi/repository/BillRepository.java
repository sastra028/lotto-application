package com.lotto.lottoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lotto.lottoapi.entity.BillEntity;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, String> {

}
