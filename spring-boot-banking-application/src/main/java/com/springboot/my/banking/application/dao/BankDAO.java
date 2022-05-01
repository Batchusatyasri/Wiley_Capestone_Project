package com.springboot.my.banking.application.dao;

import java.sql.SQLException;

import com.springboot.my.banking.application.model.Bank;

public interface BankDAO {

	public Boolean createBank(Bank bank) throws SQLException;

	public Bank viewDetailsByIFSC(String branchCode) throws SQLException;
}
