
package com.springboot.my.banking.application.model;

import java.util.Date;

public class Transaction {
	private Integer accountNo;
	private TransactionType type;
	private Date date;
	private Double amount;
	private Integer transactionNo;

	public Transaction() {
	}

	public Transaction(Integer accountNo, TransactionType type, Date date, Double amount, Integer transactionNo) {
		this.accountNo = accountNo;
		this.type = type;
		this.date = date;
		this.amount = amount;
		this.transactionNo = transactionNo;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(Integer transactionNo) {
		this.transactionNo = transactionNo;
	}

	@Override
	public String toString() {
		return "Transaction [accountNo=" + accountNo + ", type=" + type + ", date=" + date + ", amount=" + amount + "]";
	}

}
