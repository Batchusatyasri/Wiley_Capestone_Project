
package com.springboot.my.banking.application.services;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.my.banking.application.model.Branches;
import com.springboot.my.banking.application.model.Customer;
import com.springboot.my.banking.application.repository.BranchRepository;
import com.springboot.my.banking.application.repository.CustomerRepository;

@Service
public class BranchService {

	@Resource(name = "branchRepo")
	private BranchRepository branchRepository;

	@Autowired
	private CustomerRepository customerRepo;

	public Boolean createBranch(Branches branch) {
		try {
			System.out.println(branch);
			return this.branchRepository.createBranch(branch);
		} catch (SQLException e) {
			return false;
		}
	}

	public List<Branches> getBranches() {
		try {
			return this.branchRepository.showBranches();
		} catch (SQLException e) {
			return null;
		}
	}

	public Branches getBranchByIFSC(String IFSC) {
		try {
			return this.branchRepository.viewDetailsByIFSC(IFSC);
		} catch (SQLException e) {
			return null;
		}
	}

	public String deleteBranchByIFSC(String IFSC) {
		try {
			if (this.branchRepository.deleteByIFSC(IFSC)) {
				return "Branch Deleted Successfully";
			} else {
				return "Branch not Deleted";
			}
		} catch (SQLException e) {
			return "Exception Reached";
		}
	}

	public Boolean updateBranchManagerName(Branches branch) {
		try {
			return this.branchRepository.updateBranchManager(branch);
		} catch (SQLException e) {
			return false;
		}
	}

	public List<Customer> getCustomersByBranch(String branchCode) {
		try {
			return customerRepo.getCustomerByBranches(branchCode);
		} catch (SQLException e) {
			return null;
		}
	}
}