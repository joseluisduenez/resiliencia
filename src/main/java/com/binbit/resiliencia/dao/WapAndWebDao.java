package com.binbit.resiliencia.dao;

import com.binbit.resiliencia.dto.Transaction;

public interface WapAndWebDao {

	public Transaction registerPreSubscription(Transaction transaction);
	public Transaction   getPreSubscriptionById(Integer id);

}
