
package com.springboot.my.banking.application.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.my.banking.application.model.Bank;
import com.springboot.my.banking.application.model.Employees;
import com.springboot.my.banking.application.model.Transaction;

public interface EmployeeDAO {
	public List<Employees> showAllEmployees() throws SQLException;

	public Employees getEmployeeById(Integer employeeId) throws SQLException;

	public boolean updateEmployee(Integer employeeId, String employeeName, String branchCode) throws SQLException;

	public boolean deleteEmployee(Integer employeeId) throws SQLException;

	public boolean createEmployee(Employees emp) throws SQLException;

	public Bank getEmployeeBank(String branchCode) throws SQLException;

	public List<Transaction> getEmployeeTransaction(Integer empId) throws SQLException;

}