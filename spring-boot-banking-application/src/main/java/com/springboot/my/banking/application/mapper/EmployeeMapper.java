package com.springboot.my.banking.application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.my.banking.application.model.Employees;

public class EmployeeMapper implements RowMapper<Employees> {

	@Override
	public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employees employee = new Employees();
		employee.setEmpId(rs.getInt("empId"));
		employee.setName(rs.getString("name"));
		employee.setBranchCode(rs.getString("branchCode"));
		return employee;
	}

}
