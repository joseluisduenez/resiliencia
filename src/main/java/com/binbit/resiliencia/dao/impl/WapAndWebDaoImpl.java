package com.binbit.resiliencia.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.binbit.resiliencia.dao.WapAndWebDao;
import com.binbit.resiliencia.dto.Transaction;
import com.binbit.resiliencia.util.ActionType;
@Repository
public class WapAndWebDaoImpl implements WapAndWebDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
	@Override
	public Transaction registerPreSubscription(Transaction transaction) {
        final String sql = "INSERT INTO BNB_WAP_AND_WEB_SUBSCRIPTIONS"
        		+ " ( CREATED_DATE, LAST_UPDATE_DATE, shortCode, msisdn, service_id, status,channel)"
        		+ " VALUES ( ?, ?, ?, ?, ?, ?, ?)";
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
    	            pst.setString(5, transaction.getProduct().getServiceId().toString());
    	            pst.setString(6, transaction.getSubscriptionStatus().toString());
    	            pst.setString(6, transaction.getChannel());


     	            return pst;
    	        }
    	    },
    	    keyHolder);
    	transaction.setId((Integer)keyHolder.getKey());
    	return transaction;
	}

	@Override
	public Transaction getPreSubscriptionById(Integer id) {
		Transaction bill = (Transaction) jdbcTemplate.queryForObject("SELECT * FROM BNB_WAP_AND_WEB_SUBSCRIPTIONS where id = ? ",
                new Object[] { id }, new BeanPropertyRowMapper<Transaction>(Transaction.class));
     
            return bill;	
	}

}
