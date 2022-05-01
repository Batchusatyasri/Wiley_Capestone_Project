package com.springboot.my.banking.application.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.my.banking.application.model.Transaction;

public interface TransactionDAO {
	public Boolean deposit(Double amount, Integer accNo) throws SQLException;

	public Boolean withdraw(Double amount, Integer accNo) throws SQLException;

	public List<Transaction> showTransactions() throws SQLException;

}
