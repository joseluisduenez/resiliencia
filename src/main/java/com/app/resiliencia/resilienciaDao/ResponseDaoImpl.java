package com.app.resiliencia.resilienciaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.resiliencia.model.Catalog;
import com.app.resiliencia.model.User;
@Transactional
@Repository
public class ResponseDaoImpl implements ResponseDao {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    JdbcTemplate jdbcTemplate;
	@Override
	public List<Catalog> getRows(Integer questionId) {
		  List<Catalog> pr =  jdbcTemplate.query("select * from RS_RESPONSE where questionid = ?  order by number asc ",
	                new Object[] {questionId}, new BeanPropertyRowMapper<Catalog>(Catalog.class));

	        return pr;	}

	@Override
	public void removeRow(Integer id) {
		// TODO Auto-generated method stub
		final String sql = "UPDATE RS_RESPONSE SET status = ?  WHERE id = ? ";
		jdbcTemplate.update(sql,
				0,id);
	}

	@Override
	public void addRow(Catalog p) {
		// TODO Auto-generated method stub
		final String sql = "INSERT INTO RS_RESPONSE (id, name, status, createdAt,questionid,number "+")  VALUES ( ?,?,?, ?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
    	jdbcTemplate.update(
    	    new PreparedStatementCreator() {
    	        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
    	            PreparedStatement pst =
    	                con.prepareStatement(sql, new String[] {"id"});
     	            pst.setInt(1, p.getId());
     	            pst.setString(2, p.getName()==null?"":p.getName());
     	            pst.setInt(3, p.getStatus());
     	            pst.setTimestamp(4, new java.sql.Timestamp(new Date().getTime()));
     	            pst.setInt(5, p.getQuestionid());
     	            pst.setInt(6, p.getNumber());

     	            return pst;
    	        }
    	    },
    	    keyHolder);
	}

	@Override
	public Catalog getDataById(Integer id) {
		// TODO Auto-generated method stub
		Catalog pr = null;
		try {
			pr =	(Catalog) jdbcTemplate.queryForObject("select * from RS_RESPONSE where id= ?  ",
	                new Object[] { id }, new BeanPropertyRowMapper<Catalog>(Catalog.class));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	        return pr;		}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		Integer pr =  (Integer) jdbcTemplate.queryForObject("select case when max(id) > 0 then max(id)+1 else 1 end as valor from RS_RESPONSE ",
	                new Object[] { }, Integer.class);

	        return pr;
	}

}
