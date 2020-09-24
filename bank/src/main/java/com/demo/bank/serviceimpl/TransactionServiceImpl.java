package com.demo.bank.serviceimpl;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.bank.entity.Account;
import com.demo.bank.entity.Transction;
import com.demo.bank.exception.TransactionException;
import com.demo.bank.model.ResponseMessage;
import com.demo.bank.model.TransactionHistoryInput;
import com.demo.bank.model.TransactionModel;
import com.demo.bank.repository.AccountRepository;
import com.demo.bank.repository.TransactionRepository;
import com.demo.bank.service.TransactionService;
import com.demo.bank.utils.DateUtills;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	AccountRepository accountRepo;

	@Autowired
	TransactionRepository transactionRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);

	@Override
	public ResponseMessage fundsTransactions(TransactionModel model) {

		LOGGER.info("transactions validations happening in TransactionServiceImpl layer ");

		long fromAccountNumber = model.getFromAccountNumber();
		long toAccountNumber = model.getToAccounNumber();
		double fromAccountUserTransactionAmount = model.getAmount();

		Account fromAccountEntity = accountRepo.findByAccountNumber(fromAccountNumber);
		Account toAccountEntity = accountRepo.findByAccountNumber(toAccountNumber);

		Double fromAccountActualBalance = fromAccountEntity.getBalance();

		if (fromAccountUserTransactionAmount > fromAccountActualBalance) {

			LOGGER.info("validating the account  user funds");

			throw new TransactionException(
					"your transaction is failed due to insufficent funds in your account ! Please credit the amount and try it");
		}

		double fromUserFinalBalance = fromAccountEntity.getBalance() - fromAccountUserTransactionAmount;
		fromAccountEntity.setBalance(fromUserFinalBalance);
		accountRepo.save(fromAccountEntity);

		double toUserFinalBalance = toAccountEntity.getBalance() + fromAccountUserTransactionAmount;
		toAccountEntity.setBalance(toUserFinalBalance);
		accountRepo.save(toAccountEntity);

		Transction transaction = new Transction();
		transaction.setFromAccount(fromAccountNumber);
		transaction.setToAccount(toAccountNumber);
		transaction.setTransactionType(model.getTransactionType());
		transaction.setDate(LocalDate.now());
		transaction.setTransferredAmount(fromAccountUserTransactionAmount);
		transactionRepo.save(transaction);

		ResponseMessage response = new ResponseMessage();
		response.setMessage("transaction completed sucessfully");
		response.setStatusCode(HttpStatus.ACCEPTED.value());
		return response;
	}

	@Override
	public List<Transction> getTransactions(TransactionHistoryInput transactions) throws ParseException {
		String userEnteredMonth = transactions.getMonth();
		int userEnteredYear = transactions.getYear();
		long accountNumber = transactions.getAccountNumber();
		long toAccountNumber = transactions.getAccountNumber();

		int monthNumber = DateUtills.getMonthNumber(userEnteredMonth);

		String startDateMonth = DateUtills.getMonthFirstDay(userEnteredYear, monthNumber);

		String endUserEnteredDate = DateUtills.getMonthLastDaysss(userEnteredYear, monthNumber);

		LocalDate startDate = LocalDate.parse(startDateMonth);

		LocalDate parseDateFormatEndDate = LocalDate.parse(endUserEnteredDate);

		/*
		 * List<Transction> transactionDetails =
		 * transactionRepo.getUserMonthTransactions(accountNumber, startDate,
		 * parseDateFormatEndDate);
		 */

		List<Transction> transactionDetails = transactionRepo.findByFromAccountOrToAccount(accountNumber,
				toAccountNumber);

		List<Transction> listOfData = new ArrayList<Transction>();

		for (Transction transaction : transactionDetails) {
			if (transaction.getDate().isAfter(startDate) && transaction.getDate().isBefore(parseDateFormatEndDate)) {

				Transction ts = new Transction();

				BeanUtils.copyProperties(transaction, ts);

				listOfData.add(ts);

			}
		}

		return listOfData;
	}

}
