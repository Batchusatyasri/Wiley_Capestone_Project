
package com.springboot.my.banking.application.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my.banking.application.mapper.AddressMapper;
import com.springboot.my.banking.application.model.Branches;
import com.springboot.my.banking.application.model.Customer;
import com.springboot.my.banking.application.services.BranchService;



@RestController
@RequestMapping("/branches")
@CrossOrigin("http://localhost:4200")
public class BranchController {

	@Autowired
	BranchService branchService;
//	@Autowired
//	CustomerRepository customerRepository;

	@GetMapping("/all")
	public List<Branches> showBranches() {
		return branchService.getBranches();

	}

	@PostMapping("/create")
	public Boolean createNewBranch(@RequestBody Map<String, String> map) {
		System.out.println("map" + map);
		return branchService.createBranch(new Branches(map.get("branchCode"), map.get("bankCode"), map.get("manager"),
				AddressMapper.processAddress(map.get("address")), Integer.parseInt(map.get("headOffice"))));
	}

	@GetMapping("/getBranchDetails")
	public Branches showBranchByIFSC(@RequestParam String ifscCode) {
		System.out.println("ifscCode from showBrnahc " + ifscCode);
		return branchService.getBranchByIFSC(ifscCode);
	}



	@PatchMapping("/update")
	public Boolean updateBranch(@RequestBody Map<String, String> map) {
		return branchService
				.updateBranchManagerName(new Branches(map.get("branchCode"), map.get("bankCode"), map.get("manager"),
						AddressMapper.processAddress(map.get("address")), Integer.parseInt(map.get("headOffice"))));
	}

	@GetMapping("/customers")
	public List<Customer> showCustomersByBranchCode(@RequestParam String branchCode) {
		return branchService.getCustomersByBranch(branchCode);
	}

}