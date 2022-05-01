
package com.springboot.my.banking.application.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.my.banking.application.model.BankAccount;



public interface BankAccountDAO {

	public Boolean createAccount(BankAccount bankAccount);

	public List<BankAccount> showAllAccounts();

	public BankAccount getAccountByAccNo(Integer accNo);

	public BankAccount getAccountDetailsById(Integer customerId);

	public Boolean deleteBankAccount(Integer accNo);

	public List<BankAccount> getAllBankAccountsByBranchCode(String branchCode) throws SQLException;

}