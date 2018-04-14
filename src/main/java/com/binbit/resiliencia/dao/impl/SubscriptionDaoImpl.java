package com.binbit.resiliencia.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.binbit.resiliencia.dao.SubscriptionDao;
import com.binbit.resiliencia.dto.Transaction;
import com.binbit.resiliencia.util.ActionType;
@Repository
public class SubscriptionDaoImpl implements SubscriptionDao{

    @Autowired
    JdbcTemplate jdbcTemplate;
	public Transaction subscribe(final Transaction transaction) {
        final String sql = "INSERT INTO BNB_OOREDOO_SUBSCRIPTIONS (CREATED_DATE, LAST_UPDATE_DATE, shortCode, msisdn, keyword, mccmnc, promo_id,"
        		+ " status, service_id)"
        		+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	KeyHolder keyHolder = new GeneratedKeyHolder();
    	jdbcTemplate.update(
    	    new PreparedStatementCreator() {
    	        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
    	            PreparedStatement pst =
    	                con.prepareStatement(sql, new String[] {ActionType.ID});
     	            pst.setTimestamp(1, new java.sql.Timestamp(transaction.getCreatedDate().getTime()));
    	            pst.setTimestamp(2, new java.sql.Timestamp(transaction.getLastUpdateDate().getTime()));
    	            pst.setInt(3, transaction.getShortCode());
    	            pst.setString(4, transaction.getMsisdn());
    	            pst.setString(5, transaction.getKeywordModel().getKeywordName());
    	            pst.setInt(6, transaction.getMccmnc());
    	            pst.setInt(7, transaction.getPromoId());
    	            pst.setInt(8, transaction.getSubscriptionStatus());
    	            pst.setInt(9, transaction.getProduct().getServiceId());
     	      
     	            return pst;
    	        }
    	    },
    	    keyHolder);
    	transaction.setId((Integer)keyHolder.getKey());
    	return transaction;
	}
	public void unsubscribe(Transaction transaction) {


		String sql = "UPDATE BNB_OOREDOO_SUBSCRIPTIONS SET LAST_UPDATE_DATE = ?, "
 				+ "status = ?"
				+ " WHERE msisdn = ? and short_code = ? and  service_id = ?";
        jdbcTemplate.update(sql,transaction.getSubscriptionStatus(), transaction.getMsisdn(),
        		transaction.getShortCode(),transaction.getProduct().getServiceId());            
 		}

}
