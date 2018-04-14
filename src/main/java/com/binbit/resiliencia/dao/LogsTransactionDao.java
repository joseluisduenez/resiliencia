package com.binbit.resiliencia.dao;

import com.binbit.resiliencia.dto.Transaction;

public interface LogsTransactionDao {

	public Transaction saveTransaction(Transaction transaction);
	public Transaction updateTransaction(Transaction transaction);
	public Transaction getTransactionById(int id);
	public Transaction getSubscriberByMsisdnANDServiceId(String msisdn, Integer serviceIdPromos);
	public Transaction getSubscriberByMsisdnANDServiceIdPromos(String msisdn, Integer serviceIdPromos);
	public Transaction getSubscriberByMsisdnANDServiceIdApiCore(String msisdn, Integer serviceIdApicore);
	public Transaction getTransactionByCorrelatorId(String id);
	public Transaction getSubscriberByMsisdnANDProductId(String msisdn, Integer productId);



}
