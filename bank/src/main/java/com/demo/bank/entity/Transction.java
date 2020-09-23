package com.demo.bank.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "transactions")
public class Transction {

	@Id
	@NotNull(message = "ID is required")
	@Column(name = "transaction_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	private long fromAccount;
	private long toAccount;
	private double transferredAmount;
	private LocalDate date;
	private String transactionType;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public long getToAccount() {
		return toAccount;
	}

	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}

	public double getTransferredAmount() {
		return transferredAmount;
	}

	public void setTransferredAmount(double transferredAmount) {
		this.transferredAmount = transferredAmount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "Transction [transactionId=" + transactionId + ", fromAccount=" + fromAccount + ", toAccount="
				+ toAccount + ", transferredAmount=" + transferredAmount + ", date=" + date + ", transactionType="
				+ transactionType + "]";
	}

}
