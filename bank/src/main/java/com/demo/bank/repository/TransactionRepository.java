package com.demo.bank.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.bank.entity.Transction;

@Repository
public interface TransactionRepository extends JpaRepository<Transction, Long> {

	/*
	 * @Query("select ts from Transction as ts  where ts.fromAccount=:fromAccount and ts.date between ts.date=:fromFate and ts.date=:toDate"
	 * ) List<Transction> getUserMonthTransactions(@Param("fromAccount") long
	 * fromAccount,
	 * 
	 * @Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate
	 * toDate);
	 */

	List<Transction> findByFromAccountOrToAccount(@Param("fromAccount") long fromAccount,
			@Param("toAccount") long toAccount);

}
