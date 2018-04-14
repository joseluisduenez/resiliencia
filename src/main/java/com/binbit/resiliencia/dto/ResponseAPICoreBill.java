package com.binbit.resiliencia.dto;

import java.util.List;

public class ResponseAPICoreBill {

	private String status;
	private String message;
	private Integer statusCode;
	private List<BillUser> data;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public List<BillUser> getData() {
		return data;
	}

	public void setData(List<BillUser> data) {
		this.data = data;
	}

 }
