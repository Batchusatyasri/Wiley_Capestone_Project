
package com.springboot.my.banking.application.model;

public class SavingsAccount extends BankAccount {
	static final double RATEOFINTEREST=4 ;
	public SavingsAccount(Integer accountNo, Integer customerId, String branchCode, Double balance, String type) {
		super(accountNo, customerId, branchCode, balance, type);
	}
	public SavingsAccount()
	{
		
	}
	@Override
	double calculateCharges() {
		double charges = 100; // Service Charge
		if (super.getAccBalance() < 5000) {
			charges += ((5000 - super.getAccBalance()) % 100) * 5 + 75;
		}
		return charges;
	}

	@Override
	double calculateInterest() {
		return (super.getAccBalance() * 3) / 100;
	}

}
