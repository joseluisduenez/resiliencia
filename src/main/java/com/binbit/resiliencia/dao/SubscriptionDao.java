package com.binbit.resiliencia.dao;

import com.binbit.resiliencia.dto.Transaction;

public interface SubscriptionDao {

	public Transaction subscribe(final Transaction transaction);
	public void unsubscribe(final Transaction transaction);

}
