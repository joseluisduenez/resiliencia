package com.binbit.resiliencia.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.binbit.resiliencia.dao.ProductDao;
import com.binbit.resiliencia.model.Product;

import java.sql.SQLException;


@Repository
public class ProductDaoImpl implements ProductDao{
    @Autowired
    JdbcTemplate jdbcTemplate;
	public Product getProductByServiceName(final String serviceName, final Integer pricepointId) {

		Product product = (Product) jdbcTemplate.queryForObject("SELECT * FROM BNB_SERVICES where service_name = ? AND pricepointId = ? ",
                new Object[] { serviceName.trim().toUpperCase(),pricepointId }, new BeanPropertyRowMapper<Product>(Product.class));
     
            return product;		 
		}
	
	public Product getProductByProductId(final Integer productId, final Integer pricepointId) {

		Product product = (Product) jdbcTemplate.queryForObject("SELECT * FROM BNB_SERVICES where product_id = ? AND pricepointId = ? ",
                new Object[] { productId, pricepointId }, new BeanPropertyRowMapper<Product>(Product.class));
     
            return product;		 
		}

	@Override
	public Product getProductByServicePromosId(Integer productId) {

		Product product = (Product) jdbcTemplate.queryForObject("SELECT * FROM BNB_SERVICES where serviceIdPromos = ? ",
				new Object[] { productId }, new BeanPropertyRowMapper<Product>(Product.class));

		return product;		}

    @Override
    public Product getProductByPricepointId(Integer pricepointId) {
		Product product = (Product) jdbcTemplate.queryForObject("SELECT * FROM BNB_SERVICES where pricepointId = ? ",
				new Object[] { pricepointId }, new BeanPropertyRowMapper<Product>(Product.class));

		return product;
	}

	@Override
	public Product getProductById(Integer productId) {
		Product product = (Product) jdbcTemplate.queryForObject("SELECT * FROM BNB_SERVICES where service_id = ? ",
				new Object[] { productId }, new BeanPropertyRowMapper<Product>(Product.class));

		return product;

	}

	@Override
	public Product getProductByIdApiCore(Integer productId) {
		Product product = (Product) jdbcTemplate.queryForObject("SELECT * FROM BNB_SERVICES where id_api_core = ? ",
				new Object[] { productId }, new BeanPropertyRowMapper<Product>(Product.class));
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;		}

	@Override
	public Product getProductByProductIdAndLan(Integer productId) {
		Product product = (Product) jdbcTemplate.queryForObject("SELECT * FROM BNB_SERVICES where product_id = ? AND lan = 'English' ",
				new Object[] { productId }, new BeanPropertyRowMapper<Product>(Product.class));

		return product;		}

}
