package com.lotto.lottoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lotto.lottoapi.entity.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {
	AccountEntity findFirstByUsername(String username);
	AccountEntity findFirstByUsernameAndActive(String username, String active);
}
