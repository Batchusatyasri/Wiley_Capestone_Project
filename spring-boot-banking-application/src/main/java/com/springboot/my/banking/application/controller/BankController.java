package com.springboot.my.banking.application.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my.banking.application.mapper.AddressMapper;
import com.springboot.my.banking.application.model.Bank;
import com.springboot.my.banking.application.services.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {

	@Autowired
	private BankService bankService;

	@PostMapping("/create")
	public Boolean createBank(@RequestBody Map<String, String> body) {

		return this.bankService.createBank(new Bank(body.get("bankCode"), body.get("bankName"),
				AddressMapper.processAddress(body.get("mainOfficeAddress"))));
	}

	@GetMapping("/viewDetails")
	public Bank viewDetails(@RequestParam String ifscCode) {
		System.out.println("IFSC code" + ifscCode);
		return this.bankService.viewDetails(ifscCode);
	}
}