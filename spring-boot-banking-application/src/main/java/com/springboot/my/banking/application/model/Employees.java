package com.springboot.my.banking.application.model;

public class Employees {
	private Integer empId;
	private String name;
	private String branchCode;

	public Employees() {
	}

	public Employees(Integer empId, String name, String branchCode) {
		this.empId = empId;
		this.name = name;
		this.branchCode = branchCode;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	@Override
	public String toString() {
		return "Employees [empId=" + empId + ", name=" + name + ", branchCode=" + branchCode + "]";
	}

}
