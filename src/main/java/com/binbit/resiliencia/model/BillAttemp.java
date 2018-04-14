package com.binbit.resiliencia.model;

import java.util.Date;

public class BillAttemp {

	private int id;
	private int idBill;
	private Date createdDate;
	private int attemps;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdBill() {
		return idBill;
	}
	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getAttemps() {
		return attemps;
	}
	public void setAttemps(int attemps) {
		this.attemps = attemps;
	}
	
}
