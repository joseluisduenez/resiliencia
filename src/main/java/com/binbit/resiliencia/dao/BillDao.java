package com.binbit.resiliencia.dao;

import java.util.List;

import com.binbit.resiliencia.dto.Transaction;

public interface BillDao {

	public Transaction registerBill(Transaction transaction);
	public void updateBill(Transaction transaction);
	public List < Transaction > getBillsPendingToRegisterInApiCore();
	public List < Transaction > getBillsWithPendingMTToSend();
	public Transaction   getBillByMSISDN(String msidn);
	public Transaction   getBillById(Integer id);
	public List < Transaction > getBillsWithPendingFallback();
	public List < Transaction > getBillsRenewal();

	 
}
