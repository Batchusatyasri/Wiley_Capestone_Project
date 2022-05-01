package com.springboot.my.banking.application.model;

import java.sql.Timestamp;

public class ReversalRequests {
	private Integer reqId;
	private Integer transactionNo;
	private Timestamp reqDate;

	public ReversalRequests() {
	}

	public ReversalRequests(Integer reqId, Integer transactionNo, Timestamp reqDate) {
		this.reqId = reqId;
		this.transactionNo = transactionNo;
		this.reqDate = reqDate;
	}

	public Integer getReqId() {
		return reqId;
	}

	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}

	public Integer getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(Integer transactionNo) {
		this.transactionNo = transactionNo;
	}

	public Timestamp getReqDate() {
		return reqDate;
	}

	public void setReqDate(Timestamp reqDate) {
		this.reqDate = reqDate;
	}

	@Override
	public String toString() {
		return "ReversalRequests [reqId=" + reqId + ", transactionNo=" + transactionNo + ", reqDate=" + reqDate + "]";
	}

}
