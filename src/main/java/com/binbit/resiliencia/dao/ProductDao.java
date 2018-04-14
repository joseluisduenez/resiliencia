package com.binbit.resiliencia.dao;

import com.binbit.resiliencia.model.Product;

public interface ProductDao {

	public Product getProductByServiceName(final String serviceName,  final Integer pricepointId);
	public Product getProductByProductId(final Integer productId, final Integer pricepointId);
	public Product getProductByServicePromosId(Integer productId);
	public Product getProductByPricepointId(Integer productId);
	public Product getProductById(Integer productId);
	public Product getProductByIdApiCore(Integer idApicore);
	public Product getProductByProductIdAndLan(final Integer productId);

}
