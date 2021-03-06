package com.springboot.my.banking.application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.my.banking.application.model.Admin;

public class AdminMapper implements RowMapper<Admin> {

	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Admin admin = new Admin();
		admin.setAdminId(rs.getInt("adminId"));
		admin.setName(rs.getString("name"));
		admin.setBankCode(rs.getString("bankCode"));
		return admin;
	}

}
