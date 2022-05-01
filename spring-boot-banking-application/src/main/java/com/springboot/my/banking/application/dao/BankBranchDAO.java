package com.springboot.my.banking.application.dao;

import java.sql.SQLException;
public interface BankBranchDAO {

	public Boolean updateByIFSC(String ifscCode) throws SQLException;

	public Boolean deleteByIFSC(String ifscCode) throws SQLException;

}