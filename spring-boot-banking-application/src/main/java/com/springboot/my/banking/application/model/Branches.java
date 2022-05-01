
package com.springboot.my.banking.application.model;

import java.util.Objects;

public class Branches implements Comparable<Branches> {
	private String branchCode;
	private String bankCode;
	private String manager;
	private Address address;
	private Integer headOffice;

	public Branches() {
		super();
	}

	public Branches(String branchCode, String bankCode, String manager, Address address, Integer headOffice) {
		super();
		this.branchCode = branchCode;
		this.bankCode = bankCode;
		this.manager = manager;
		this.address = address;
		this.headOffice = headOffice;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getHeadOffice() {
		return headOffice;
	}

	public void setHeadOffice(Integer headOffice) {
		this.headOffice = headOffice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bankCode, branchCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Branches other = (Branches) obj;
		return Objects.equals(bankCode, other.bankCode) && Objects.equals(branchCode, other.branchCode);
	}

	@Override
	public int compareTo(Branches o) {
		if (this.equals(o))
			return 0;
		else
			return 1;
	}

	@Override
	public String toString() {
		return "Branches [branchCode=" + branchCode + ", bankCode=" + bankCode + ", manager=" + manager + ", address="
				+ address + ", headOffice=" + headOffice + "]";
	}

}
