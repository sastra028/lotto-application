package com.lotto.lottoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lotto.lottoapi.entity.RewardEntity;

@Repository
public interface RewardRepository extends JpaRepository<RewardEntity, String> {

}
