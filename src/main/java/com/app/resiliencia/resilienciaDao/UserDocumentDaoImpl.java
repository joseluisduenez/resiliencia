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

import com.app.resiliencia.model.User;
import com.app.resiliencia.model.UserDocument;
@Transactional
@Repository
public class UserDocumentDaoImpl implements UserDocumentDao {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    JdbcTemplate jdbcTemplate;
	@Override
	public List<UserDocument> getUserDocs(Integer Userid) {
		// TODO Auto-generated method stub
	    List<UserDocument> docs =  jdbcTemplate.query("select * from RS_USER_DOC where status = 1 and userid = ? order by createdAt desc ",
                new Object[] { Userid }, new BeanPropertyRowMapper<UserDocument>(UserDocument.class));

        return docs;
	}

	@Override
	public UserDocument getDocById(Integer id) {
		// TODO Auto-generated method stub
		UserDocument User = (UserDocument) jdbcTemplate.queryForObject("SELECT * FROM RS_USER_DOC where id = ? ",
				new Object[] { id },  new BeanPropertyRowMapper<UserDocument>(UserDocument.class));
		return User;	
	}

	@Override
	public void addDocument(UserDocument doc) {
		// TODO Auto-generated method stub
		final String sql = "INSERT INTO RS_USER_DOC (id,userId, createdAt, fileName,docName, "
        		+ "comments, status, docType"
        		+ ")  VALUES ( ?,?,?, ?, ?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
    	jdbcTemplate.update(
    	    new PreparedStatementCreator() {
    	        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
    	            PreparedStatement pst =
    	                con.prepareStatement(sql, new String[] {"id"});
     	            pst.setInt(1, doc.getId());
     	            pst.setInt(2, doc.getUserId());
     	            pst.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
     	            pst.setString(4, doc.getFileName()==null?"":doc.getFileName());
     	            pst.setString(5, doc.getDocName()==null?"":doc.getDocName());
     	            pst.setString(6, doc.getComments()==null?"":doc.getComments());
     	            pst.setInt(7, doc.getStatus()==null?0:doc.getStatus());
     	            pst.setString(8, doc.getDocType()==null?"":doc.getDocType());

     	            return pst;
    	        }
    	    },
    	    keyHolder);
	}

	@Override
	public void updateDocument(UserDocument doc) {
		// TODO Auto-generated method stub
		final String sql = "UPDATE RS_USER_DOC SET fileName = ?, docName = ?, comments = ?, status = ?  WHERE id = ? ";
		jdbcTemplate.update(sql,
				doc.getFileName()==null?"":doc.getFileName(),
						doc.getDocName()==null?"":doc.getDocName(),
								doc.getComments()==null?"":doc.getComments(),
						doc.getStatus()
						,doc.getId());
	}

	@Override
	public void deleteDoc(Integer id) {
		// TODO Auto-generated method stub
		final String sql = "UPDATE RS_USER_DOC SET status = ?  WHERE id = ? ";
		jdbcTemplate.update(sql,
				0,id);
	}

	@Override
	public Integer getLastId() {
		// TODO Auto-generated method stub
				Integer id = (Integer) jdbcTemplate.queryForObject("SELECT (max(id)+1) FROM  RS_USER_DOC ",
						new Object[] { },   Integer.class );
				return id;
	}

}
