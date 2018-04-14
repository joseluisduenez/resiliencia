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

import com.binbit.resiliencia.dao.BillAttempDao;
import com.binbit.resiliencia.model.BillAttemp;
import com.binbit.resiliencia.util.ActionType;
@Repository
public class BillAttempDaoImpl implements BillAttempDao{
	@Autowired
    JdbcTemplate jdbcTemplate;
	@Override
	public BillAttemp createBillAtempEntity(BillAttemp billAttemp) {
        final String sql = "INSERT INTO BNB_BILL_ATTEMPS"
        		+ " ( ID_BILL, CREATED_DATE, ATTEMPS)"
        		+ " VALUES ( ?, ?, ?)";
    	KeyHolder keyHolder = new GeneratedKeyHolder();
    	jdbcTemplate.update(
    	    new PreparedStatementCreator() {
    	        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
    	            PreparedStatement pst =
    	                con.prepareStatement(sql, new String[] {ActionType.ID});
    	            pst.setInt(1, billAttemp.getIdBill());
    	            pst.setDate(2, new java.sql.Date(billAttemp.getCreatedDate().getTime()));
    	            pst.setInt(3, billAttemp.getAttemps());
 
     	            return pst;
    	        }
    	    },
    	    keyHolder);
    	billAttemp.setId((Integer)keyHolder.getKey());
    	return billAttemp;
	}

	@Override
	public BillAttemp getBillAttempByCreationDate(BillAttemp billAttemp) {
		 billAttemp = (BillAttemp) jdbcTemplate.queryForObject("SELECT * FROM BNB_BILL_ATTEMPS where CREATED_DATE = ? ",
                new Object[] { billAttemp.getCreatedDate() }, new BeanPropertyRowMapper<BillAttemp>(BillAttemp.class));
     
            return billAttemp;	
	}

	@Override
	public BillAttemp updateBillAttemp(BillAttemp billAttemp) {
		String sql = "UPDATE BNB_BILL_ATTEMPS SET ATTEMPS = ? WHERE ID_BILL = ? AND CREATED_DATE = ? ";
        jdbcTemplate.update(sql,billAttemp.getAttemps(),billAttemp.getIdBill(),billAttemp.getCreatedDate());            
        return billAttemp;
 	}

}
