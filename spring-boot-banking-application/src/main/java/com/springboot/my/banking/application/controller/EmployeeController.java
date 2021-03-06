package com.springboot.my.banking.application.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my.banking.application.model.Bank;
import com.springboot.my.banking.application.model.BankAccount;
import com.springboot.my.banking.application.model.Customer;
import com.springboot.my.banking.application.model.Employees;
import com.springboot.my.banking.application.model.Transaction;
import com.springboot.my.banking.application.repository.BankAccountRepository;
import com.springboot.my.banking.application.repository.CustomerRepository;
import com.springboot.my.banking.application.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private BankAccountRepository bankAccountRepository;

	@GetMapping("/{empId}")
	public String getCustomerName(@PathVariable Integer empId) {
		Employees e;
		try {
			e = employeeRepository.getEmployeeById(empId);
			return e.getName();
		} catch (SQLException e1) {
			return null;
		}

	}

	@GetMapping("/bank")
	public Bank getBankName(@RequestParam String branchCode) {
		try {
			return employeeRepository.getEmployeeBank(branchCode);
		} catch (SQLException e) {
			return null;
		}
	}

	@GetMapping("/bankaccount/{branchCode}")
	public List<BankAccount> getAccountByBranchCode(@PathVariable String branchCode) {
		try {
			return bankAccountRepository.getAllBankAccountsByBranchCode(branchCode);
		} catch (SQLException e) {
			return null;
		}
	}

	@GetMapping("/customers/{branch}")
	public List<Customer> getCustomerByBranchCode(@PathVariable String branch) {
		try {
			return customerRepository.getCustomerByBranchCode(branch);
		} catch (SQLException e) {
			return null;
		}
	}

	@GetMapping()
	public Employees showCustomerById(@RequestParam Integer empId) {
		try {
			return employeeRepository.getEmployeeById(empId);
		} catch (SQLException e) {
			return null;
		}
	}

	@DeleteMapping()
	public Boolean deleteCustomer(@RequestParam Integer customerId) throws SQLException {
		return customerRepository.deleteCustomerById(customerId);
	}

	@GetMapping("/transactions")
	public List<Transaction> getEmployeeTransactions(@RequestParam Integer empId) {
		try {
			return employeeRepository.getEmployeeTransaction(empId);
		} catch (SQLException e) {
			return null;
		}
	}
}