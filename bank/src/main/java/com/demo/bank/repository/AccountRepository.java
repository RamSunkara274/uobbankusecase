package com.demo.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.bank.entity.Account;
import java.lang.Long;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByAccountNumber(Long accountNumber);

}
