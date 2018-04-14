package com.binbit.resiliencia.dao;

import com.binbit.resiliencia.model.PricePoint;

public interface PricePointDao {

	public PricePoint getPricePointById(Integer id);
	public PricePoint getPricePointByProductWeekly(Integer productId);
	public PricePoint getPricePointByProductDaily(Integer productId);
	public PricePoint getFreePricePoint();

}
