package com.springboot.my.banking.application.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.my.banking.application.model.Branches;
import com.springboot.my.banking.application.model.Customer;
import com.springboot.my.banking.application.model.Transaction;

public interface BranchDAO {
	public Boolean createBranch(Branches branch) throws SQLException;

	public List<Branches> showBranches() throws SQLException;

	public Branches viewDetailsByIFSC(String ifscCode) throws SQLException;

	public Boolean updateBranchManager(Branches branch) throws SQLException;

	public Boolean deleteByIFSC(String ifscCode) throws SQLException;

	public List<Transaction> showTransactions() throws SQLException;

	public List<Customer> showCustomers() throws SQLException;

}
