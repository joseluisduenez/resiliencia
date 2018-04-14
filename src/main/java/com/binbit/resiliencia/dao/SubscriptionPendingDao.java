package com.binbit.resiliencia.dao;

import java.util.List;

import com.binbit.resiliencia.dto.Transaction;

public interface SubscriptionPendingDao {

	public Transaction registerSubscription(Transaction transaction);
	public void updateSubscription(Transaction transaction);
	public List<Transaction> getPendingToSubscribeInApiCore();
	
}
