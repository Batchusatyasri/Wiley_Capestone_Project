
package com.springboot.my.banking.application.model;

public abstract class BankAccount {
	private Integer accountNo;
	private Integer customerId;
	private String branchCode;
	private Double balance;
	private String type;

	public BankAccount(Integer accountNo, Integer customerId, String branchCode, Double balance, String type) {
		this.accountNo = accountNo;
		this.customerId = customerId;
		this.branchCode = branchCode;
		this.balance = balance;
		this.type = type;
	}
	public BankAccount()
	{
		
	}
	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAccBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	abstract double calculateCharges();

	abstract double calculateInterest();

	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", customerId=" + customerId + ", branchCode=" + branchCode
				+ ", type=" + type + "]";
	}

}
