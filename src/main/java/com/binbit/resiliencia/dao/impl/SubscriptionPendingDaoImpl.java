package com.binbit.resiliencia.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

 import com.binbit.resiliencia.dao.SubscriptionPendingDao;
import com.binbit.resiliencia.dto.Transaction;
import com.binbit.resiliencia.util.Status;

@Repository
public class SubscriptionPendingDaoImpl implements SubscriptionPendingDao{


    @Autowired
    JdbcTemplate jdbcTemplate;
    
	public Transaction registerSubscription(final Transaction transaction) {
//        final String sql = "INSERT INTO BNB_OOREDOO_PENDING_TO_SUBSCRIBE"
//        		+ " ( CREATED_DATE, LAST_UPDATE_DATE, shortCode, msisdn, textbin, smsc, idSmsc, delivery,"
//        		+ " mclass, udh, charset, billing, osmsc, metaData, status)"
//        		+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//    	KeyHolder keyHolder = new GeneratedKeyHolder();
//    	jdbcTemplate.update(
//    	    new PreparedStatementCreator() {
//    	        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//    	            PreparedStatement pst =
//    	                con.prepareStatement(sql, new String[] {ActionType.ID});
//    	            pst.setTimestamp(1, new java.sql.Timestamp(transaction.getCreatedDate().getTime()));
//    	            pst.setTimestamp(2, new java.sql.Timestamp(transaction.getLastUpdateDate().getTime()));
//    	            pst.setInt(3, transaction.getShortCode());
//    	            pst.setString(4, transaction.getMsisdn());
//    	            pst.setString(5, transaction.getTextbin());
//    	            pst.setString(6, transaction.getSmsc());
//    	            pst.setString(7, transaction.getIdSmsc());
//    	            pst.setString(8, transaction.getDelivery());
//    	            pst.setString(9, transaction.getMclass());
//    	            pst.setString(10, transaction.getUdh());
//    	            pst.setString(11, transaction.getCharset());
//    	            pst.setString(12, transaction.getBilling());
//    	            pst.setString(13, transaction.getOsmsc());
//    	            pst.setString(14, transaction.getMetaData());
//    	            pst.setInt(15, transaction.getSubscriptionStatus());
//     	            return pst;
//    	        }
//    	    },
//    	    keyHolder);
//    	transaction.setId((Integer)keyHolder.getKey());
//    	return transaction;
		return null;
	}

	public void updateSubscription(Transaction transaction) {
//		String sql = "UPDATE BNB_OOREDOO_PENDING_TO_SUBSCRIBE SET LAST_UPDATE_DATE = ? , shortCode = ? , msisdn = ?, "
//				+ " textbin = ?, smsc = ?, idSmsc = ?, delivery = ?, mclass = ?, udh = ?, charset = ?, billing = ?, osmsc = ?, metaData = ?,"
//				+ "status = ?"
//				+ " WHERE id = ?";
//        jdbcTemplate.update(sql,
//        		transaction.getLastUpdateDate(), transaction.getShortCode(), transaction.getMsisdn(),transaction.getTextbin()
//        		,transaction.getSmsc(),transaction.getIdSmsc(),transaction.getDelivery(),transaction.getMclass(),transaction.getUdh()
//        		,transaction.getCharset(),transaction.getBilling(),transaction.getOsmsc(),transaction.getMetaData(),transaction.getSubscriptionStatus(), transaction.getId());
 	}

	public List<Transaction> getPendingToSubscribeInApiCore() {
 		List<Transaction> transactions =  jdbcTemplate.query("select * from BNB_OOREDOO_PENDING_TO_SUBSCRIBE where status = ? ",
                new Object[] { Status.PENDING_SUBSCRIBE }, new BeanPropertyRowMapper<Transaction>(Transaction.class));
     
            return transactions;
	}

}
