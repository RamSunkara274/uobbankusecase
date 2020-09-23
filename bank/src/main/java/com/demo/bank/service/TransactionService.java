package com.demo.bank.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.bank.entity.Transction;
import com.demo.bank.model.ResponseMessage;
import com.demo.bank.model.TransactionHistoryInput;
import com.demo.bank.model.TransactionModel;

@Service
public interface TransactionService {

	public ResponseMessage fundsTransactions(TransactionModel model);

	public List<Transction> getTransactions(TransactionHistoryInput transactions) throws ParseException;

}
