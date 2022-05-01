package com.springboot.my.banking.application.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.my.banking.application.dao.AdminDAO;
import com.springboot.my.banking.application.mapper.AdminMapper;
import com.springboot.my.banking.application.mapper.CustomerMapper;
import com.springboot.my.banking.application.mapper.TransactionMapper;
import com.springboot.my.banking.application.model.Admin;
import com.springboot.my.banking.application.model.Customer;
import com.springboot.my.banking.application.model.Transaction;


@Repository("adminRepo")
public class AdminRepository implements AdminDAO {
	@Autowired
	JdbcTemplate jdbcTemplateObject;

	@SuppressWarnings("deprecation")
	@Override
	public Admin getAdminById(Integer adminId) throws SQLException {
		String sql = "SELECT * FROM admins WHERE adminId = ?";
		return jdbcTemplateObject.queryForObject(sql, new Object[] { adminId }, new AdminMapper());
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

//	@Override
//	public Boolean approveReversal() throws SQLException {
//		return null;
//	}
//
//	@Override
//	public Boolean rejectRevesal() throws SQLException {
//		return null;
//	}

}