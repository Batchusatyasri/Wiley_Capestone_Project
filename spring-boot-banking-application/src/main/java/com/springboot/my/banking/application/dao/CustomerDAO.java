package com.springboot.my.banking.application.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.my.banking.application.model.Customer;
import com.springboot.my.banking.application.model.Transaction;

public interface CustomerDAO {

	public Customer getCustomerById(Integer custId) throws SQLException;

	public Customer getCustomerByAccNo(Integer accNo) throws SQLException;

	public List<Customer> getCustomerByBranches(String branchCode) throws SQLException;

	public Boolean updateCustomerById(Integer custId, String name, String address) throws SQLException;

	public Boolean createCustomer(String name, String address) throws SQLException;

	public Boolean deleteCustomerById(Integer custId) throws SQLException;

	public List<Customer> getCustomerByBranchCode(String branch) throws SQLException;
	
	public List<Transaction> showTransactions(Integer custId) throws SQLException;

	public List<Transaction> showTransactionsTypeWise(Integer custId, String accType) throws SQLException;

}
