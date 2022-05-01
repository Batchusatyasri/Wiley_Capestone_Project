
package com.springboot.my.banking.application.model;

public class CurrentAccount extends BankAccount {

	public CurrentAccount(Integer accountNo, Integer customerId, String branchCode, Double balance, String type) {
		super(accountNo, customerId, branchCode, balance, type);
	}

	@Override
	double calculateCharges() {
		double charges = 100;
		if (super.getAccBalance() >= 500 && super.getAccBalance() < 1000)
			charges += 1000;
		else if (super.getAccBalance() < 500)
			charges += 1800;
		return charges;
	}

	@Override
	double calculateInterest() {
		return 0;
	}

}
