package com.binbit.resiliencia.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.binbit.resiliencia.dao.LogsTransactionDao;
 import com.binbit.resiliencia.dto.Transaction;
import com.binbit.resiliencia.util.ActionType;
   
@Repository
@Qualifier("transactionDao")
public class LogsTransactionDaoImpl implements LogsTransactionDao{


    @Autowired
    JdbcTemplate jdbcTemplate;
    
	public Transaction saveTransaction(final Transaction transaction) {
        final String sql = "INSERT INTO BNB_OOREDOO_TRANSACTIONS (ORIGINAL_TEXT, CREATED_DATE, LAST_UPDATE_DATE, msisdn," +
				"serviceName, productId, pricepointId, mccmnc, optInType, seviceIdCarrier, serviceIdApiCore, serviceIdPromos, urlPromos, urlPortal, serviceId,newSubscriber,attempId)"
        		+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ? , ?,?,?,?)";
    	KeyHolder keyHolder = new GeneratedKeyHolder();
    	jdbcTemplate.update(
    	    new PreparedStatementCreator() {
    	        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
    	            PreparedStatement pst =
    	                con.prepareStatement(sql, new String[] {ActionType.ID});
     	            pst.setString(1, transaction.getText());
    	            pst.setTimestamp(2, new java.sql.Timestamp(transaction.getCreatedDate().getTime()));
    	            pst.setTimestamp(3, new java.sql.Timestamp(transaction.getLastUpdateDate().getTime()));
    	            pst.setString(4, transaction.getMsisdn());
					pst.setString(5, transaction.getProduct().getServiceName()==null?"":transaction.getProduct().getServiceName());
					pst.setInt(6, transaction.getProduct().getProductId()==null?0:transaction.getProduct().getProductId());
					pst.setInt(7, transaction.getProduct().getPricepointId()==null?0:transaction.getProduct().getPricepointId());
					pst.setInt(8, transaction.getMccmnc()==null?0:transaction.getMccmnc());
					pst.setString(9, transaction.getOptInType()==null?"":transaction.getOptInType());
					pst.setInt(10, transaction.getProduct().getCarrierId()==null?0:transaction.getProduct().getCarrierId());
					pst.setInt(11, transaction.getProduct().getIdApiCore()==null?0:transaction.getProduct().getIdApiCore());
					pst.setInt(12, transaction.getProduct().getServiceIdPromos()==null?0:transaction.getProduct().getServiceIdPromos());
					pst.setString(13, transaction.getProduct().getUrlPromos()==null?"":transaction.getProduct().getUrlPromos());
					pst.setString(14, transaction.getProduct().getUrlPortal()==null?"":transaction.getProduct().getUrlPortal());
					pst.setInt(15, transaction.getProduct().getServiceId()==null?0:transaction.getProduct().getServiceId());
					pst.setBoolean(16, transaction.getNewSubscriber()==null?true:transaction.getNewSubscriber());
					pst.setString(17, transaction.getAttempId()==null?"":transaction.getAttempId());

					return pst;
    	        }
    	    },
    	    keyHolder);
    	transaction.setId((Integer)keyHolder.getKey());
    	return transaction;
	}

	public Transaction updateTransaction(Transaction transaction) {
		final String sql = "UPDATE BNB_OOREDOO_TRANSACTIONS SET LAST_UPDATE_DATE = ?, msisdn = ?, serviceName = ?,"
				+ " productId = ?, pricepointId = ?, mccmnc = ?, optInType = ?, seviceIdCarrier = ?," +
				" serviceIdApiCore = ?, serviceIdPromos = ?, billattemps	=	?, lastDateAttemp = ?, billed= ?, codeResponseTIMWESubscription = ?, urlPromos = ?, urlPortal = ?,newSubscriber=?, correlatorId=?,attempId=?," +
				"message = ?"
				+ " WHERE ID = ? ";
		jdbcTemplate.update(sql,new java.sql.Timestamp(transaction.getLastUpdateDate().getTime()),
	  		transaction.getMsisdn(),
			transaction.getProduct().getServiceName()==null?"":transaction.getProduct().getServiceName()
			,transaction.getProduct().getProductId()==null?0:transaction.getProduct().getProductId()
			,transaction.getProduct().getPricepointId()==null?0:transaction.getProduct().getPricepointId()
			,transaction.getMccmnc()==null?0:transaction.getMccmnc()
			,transaction.getOptInType()==null?"":transaction.getOptInType()
			,transaction.getProduct().getCarrierId()==null?0:transaction.getProduct().getCarrierId()
			,transaction.getProduct().getIdApiCore()==null?0:transaction.getProduct().getIdApiCore()
			,transaction.getProduct().getServiceIdPromos()==null?0:transaction.getProduct().getServiceIdPromos()
			,transaction.getBillattemps()==null?0:transaction.getBillattemps()
			,transaction.getLastDateAttemp()
			,transaction.getBilled() == null?false:transaction.getBilled()
			,transaction.getCodeResponseTIMWESubscription()==null?"":transaction.getCodeResponseTIMWESubscription()
			,transaction.getProduct().getUrlPromos()==null?"":transaction.getProduct().getUrlPromos()
			,transaction.getProduct().getUrlPortal()==null?"":transaction.getProduct().getUrlPortal()
				,transaction.getNewSubscriber()==null?false:transaction.getNewSubscriber()
			,transaction.getCorrelatorId()==null?"":transaction.getCorrelatorId()
				,transaction.getAttempId()==null?"":transaction.getAttempId()
				,transaction.getMessage()==null?"":transaction.getMessage()
				,transaction.getId()
		);
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transaction;
	}
	
 
	
	public Transaction getTransactionById(int id) {
		Transaction bill = (Transaction) jdbcTemplate.queryForObject("SELECT * FROM BNB_OOREDOO_TRANSACTIONS where id = ? ",
				new Object[] { id },  new BeanPropertyRowMapper<Transaction>(Transaction.class));

		return bill;
	}
	@Override
	public Transaction getTransactionByCorrelatorId(String id) {
		Transaction bill = (Transaction) jdbcTemplate.queryForObject("SELECT * FROM BNB_OOREDOO_TRANSACTIONS where correlatorId = ? ",
				new Object[] { id },  new BeanPropertyRowMapper<Transaction>(Transaction.class));

		return bill;
	}

	@Override
	public Transaction getSubscriberByMsisdnANDProductId(String msisdn, Integer productId) {
		try{
			Transaction bill = (Transaction) jdbcTemplate.queryForObject("SELECT * FROM BNB_OOREDOO_TRANSACTIONS where msisdn = ?  AND productid	=	?",
					new Object[] { msisdn, productId },  new BeanPropertyRowMapper<Transaction>(Transaction.class));
			jdbcTemplate.getDataSource().getConnection().close();
			return bill;
		}
		catch (Exception e){

			return null;
		}	}

	@Override
	public Transaction getSubscriberByMsisdnANDServiceId(String msisdn, Integer serviceIdPromos) {
		try{
			Transaction bill = (Transaction) jdbcTemplate.queryForObject("SELECT * FROM BNB_OOREDOO_TRANSACTIONS where msisdn = ?  AND serviceId	=	?",
					new Object[] { msisdn, serviceIdPromos },  new BeanPropertyRowMapper<Transaction>(Transaction.class));
			jdbcTemplate.getDataSource().getConnection().close();
			return bill;
		}
	catch (Exception e){

		return null;
	}
	}

	@Override
    public Transaction getSubscriberByMsisdnANDServiceIdPromos(String msisdn, Integer serviceId) {
		Transaction bill = (Transaction) jdbcTemplate.queryForObject("SELECT * FROM BNB_OOREDOO_TRANSACTIONS where msisdn = ?  AND serviceIdPromos  	=	?",
				new Object[] { msisdn, serviceId },  new BeanPropertyRowMapper<Transaction>(Transaction.class));

		return bill;
    }


	@Override
	public Transaction getSubscriberByMsisdnANDServiceIdApiCore(String msisdn, Integer serviceIdApiCore) {
		try{
			Transaction bill = (Transaction) jdbcTemplate.queryForObject("SELECT * FROM BNB_OOREDOO_TRANSACTIONS where msisdn = ?  AND serviceIdApiCore	=	?",
					new Object[] { msisdn, serviceIdApiCore },  new BeanPropertyRowMapper<Transaction>(Transaction.class));
			jdbcTemplate.getDataSource().getConnection().close();
			return bill;
		}
		catch (Exception e){
			return null;
		}

	}
}
