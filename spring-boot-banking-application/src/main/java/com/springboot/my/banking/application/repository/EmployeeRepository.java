package com.springboot.my.banking.application.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.my.banking.application.dao.EmployeeDAO;
import com.springboot.my.banking.application.mapper.BankMapper;
import com.springboot.my.banking.application.mapper.EmployeeMapper;
import com.springboot.my.banking.application.mapper.TransactionMapper;
import com.springboot.my.banking.application.model.Bank;
import com.springboot.my.banking.application.model.Employees;
import com.springboot.my.banking.application.model.Transaction;

@Repository("employeeRepo")
public class EmployeeRepository implements EmployeeDAO {
	@Autowired
	JdbcTemplate jdbcTemplateObject;

	@Override
	public boolean createEmployee(Employees emp) throws SQLException {
		String query = "INSERT INTO employees(name, branchCode) VALUES(?,?)";
		return jdbcTemplateObject.update(query, emp.getName(), emp.getBranchCode()) > 0;

	}

	@Override
	public boolean deleteEmployee(Integer empId) throws SQLException {
		String query = "DELETE FROM employees WHERE empId = ?";
		return jdbcTemplateObject.update(query, empId) > 0;

	}

	@SuppressWarnings("deprecation")
	public Bank getEmployeeBank(String branchCode) throws SQLException {
		String query = "select bankcode,bankname,mainOfficeAddress from banks inner join branches using(bankcode) where branchcode=?";
		return jdbcTemplateObject.queryForObject(query, new Object[] { branchCode }, new BankMapper());

	}

	@SuppressWarnings("deprecation")
	@Override
	public Employees getEmployeeById(Integer empId) throws SQLException {
		String query = "SELECT * FROM employees WHERE empId=?";
		return jdbcTemplateObject.queryForObject(query, new Object[] { empId }, new EmployeeMapper());

	}

	@Override
	public List<Employees> showAllEmployees() throws SQLException {
		String query = "SELECT * FROM employees";
		return jdbcTemplateObject.query(query, new EmployeeMapper());
	}

	@Override
	public boolean updateEmployee(Integer empId, String name, String branchCode) throws SQLException {
		String query = "UPDATE employees SET name= ? WHERE empId= ? ";
		return jdbcTemplateObject.update(query, name, empId) > 0;

	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Transaction> getEmployeeTransaction(Integer empId) throws SQLException {
		String query = "SELECT * FROM transactions where accNo in (select accNo from bank_accounts where branch = (select branchCode from employees where empId=?))";
		return jdbcTemplateObject.query(query, new Object[] { empId }, new TransactionMapper());
	}

}