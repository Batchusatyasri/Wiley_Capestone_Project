
package com.springboot.my.banking.application.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.my.banking.application.dao.BranchDAO;
import com.springboot.my.banking.application.mapper.BranchMapper;
import com.springboot.my.banking.application.mapper.CustomerMapper;
import com.springboot.my.banking.application.mapper.TransactionMapper;
import com.springboot.my.banking.application.model.Branches;
import com.springboot.my.banking.application.model.Customer;
import com.springboot.my.banking.application.model.Transaction;

@Repository("branchRepo")
public class BranchRepository implements BranchDAO {

	@Autowired
	JdbcTemplate jdbcTemplateObject;

	@Override
	public Boolean createBranch(Branches branch) throws SQLException {
		String sql = "INSERT INTO branches VALUES (?, ?, ?, ?, ?)";

		return jdbcTemplateObject.update(sql, branch.getBranchCode(), branch.getAddress().toString(),
				branch.getManager(), branch.getBankCode(), branch.getHeadOffice()) > 0;
	}
	@SuppressWarnings("deprecation")
	@Override
	public Branches viewDetailsByIFSC(String ifscCode) throws SQLException {
		String sql = "SELECT * FROM branches WHERE branchCode = ?";
		return jdbcTemplateObject.queryForObject(sql, new Object[] { ifscCode }, new BranchMapper());
	}

	@Override
	public List<Transaction> showTransactions() throws SQLException {
		String sql = "SELECT * FROM transactions";
		return jdbcTemplateObject.query(sql, new TransactionMapper());
	}

	@Override
	public List<Customer> showCustomers() throws SQLException {
		String sql = "SELECT * FROM customers";
		return jdbcTemplateObject.query(sql, new CustomerMapper());
	}

	@Override
	public List<Branches> showBranches() throws SQLException {
		String sql = "SELECT * FROM branches";
		return jdbcTemplateObject.query(sql, new BranchMapper());
	}

	@Override
	public Boolean deleteByIFSC(String ifscCode) throws SQLException {
		String sql = "DELETE FROM branches WHERE branchCode = ?";
		return jdbcTemplateObject.update(sql, ifscCode) > 0;
	}

	@Override
	public Boolean updateBranchManager(Branches branch) throws SQLException {
		String sql = "UPDATE branches SET manager=?, isHeadOffice=? WHERE branchCode= ? ";
		return jdbcTemplateObject.update(sql, branch.getManager(), branch.getHeadOffice(), branch.getBranchCode()) > 0;
	}

}