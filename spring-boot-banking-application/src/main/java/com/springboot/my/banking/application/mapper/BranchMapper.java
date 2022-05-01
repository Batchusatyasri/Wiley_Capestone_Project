
package com.springboot.my.banking.application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.my.banking.application.model.Branches;

public class BranchMapper implements RowMapper<Branches> {

	@Override
	public Branches mapRow(ResultSet rs, int rowNum) throws SQLException {
		Branches branch = new Branches();
		branch.setBranchCode(rs.getString("branchCode"));
		branch.setAddress(AddressMapper.processAddress(rs.getString("address")));
		branch.setManager(rs.getString("manager"));
		branch.setHeadOffice(Integer.parseInt(rs.getString("isHeadOffice")));
		branch.setBankCode(rs.getString("bankCode"));
		return branch;
	}

}
