package com.springboot.my.banking.application.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.my.banking.application.model.Admin;
import com.springboot.my.banking.application.model.Customer;
import com.springboot.my.banking.application.model.Transaction;

public interface AdminDAO {
	public Admin getAdminById(Integer adminId) throws SQLException;

	public List<Transaction> showTransactions() throws SQLException;

	public List<Customer> showCustomers() throws SQLException;

}
