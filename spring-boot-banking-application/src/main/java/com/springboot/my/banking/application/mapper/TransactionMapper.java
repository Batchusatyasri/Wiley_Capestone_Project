package com.springboot.my.banking.application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.my.banking.application.model.Transaction;
import com.springboot.my.banking.application.model.TransactionType;


public class TransactionMapper implements RowMapper<Transaction> {

	@Override
	public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {

		Transaction transaction = new Transaction();
		transaction.setAccountNo(rs.getInt("accNo"));
		transaction.setType(TransactionType.valueOf(rs.getString("type")));
		transaction.setDate(rs.getDate("timestamp"));
		transaction.setAmount(rs.getDouble("amount"));
		transaction.setTransactionNo(rs.getInt("transactionNo"));
		return transaction;

	}

}
