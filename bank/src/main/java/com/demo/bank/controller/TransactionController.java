package com.demo.bank.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bank.entity.Transction;
import com.demo.bank.model.ResponseMessage;
import com.demo.bank.model.TransactionHistoryInput;
import com.demo.bank.model.TransactionModel;
import com.demo.bank.service.TransactionService;

import io.swagger.annotations.ApiOperation;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	private static final Logger Logger = LoggerFactory.getLogger(TransactionController.class);

	@PostMapping("/transactions")
	@ApiOperation("funds transactions from one account to another acccount")
	public ResponseMessage fundsTransfer(@RequestBody TransactionModel transaction) {

		Logger.info("funds transfer in transaction controller");
		return transactionService.fundsTransactions(transaction);

	}

	@PostMapping("/user/transactions")
	public List<Transction> getUserTransaction(@RequestBody TransactionHistoryInput transaction) throws ParseException {

		Logger.info("get user transactions");
		return transactionService.getTransactions(transaction);

	}

}
