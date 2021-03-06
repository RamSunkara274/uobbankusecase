package com.demo.bank.model;

public class TransactionHistoryInput {

	long accountNumber;
	String month;
	int year;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "TransactionHistory [accountNumber=" + accountNumber + ", month=" + month + ", year=" + year + "]";
	}

}
