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

import com.app.resiliencia.model.Area;
import com.app.resiliencia.model.Catalog;
import com.app.resiliencia.model.Encuesta;
import com.app.resiliencia.model.Pregunta;
import com.app.resiliencia.model.Respuesta;
import com.app.resiliencia.model.SubArea;
import com.app.resiliencia.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Transactional
@Repository
public class EncuestaDaoImpl implements EncuestaDao {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	 @Autowired
	 ObjectMapper objectMapper;
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Respuesta> getRespuestas(Integer preguntaId){
    	List<Respuesta> pr =  jdbcTemplate.query("select distinct\n" + 
    			" --sub.id as id, sub.name as name\n" + 
    			" --question.id as id, question.name as name\n" + 
    			" response.id as id, response.number as number, response.name as name\n" + 
    			"from rs_area_catalog area\n" + 
    			"inner join  rs_subarea_catalog sub on sub.areaid = area.id \n" + 
    			"inner join rs_question question on question.subareaid = sub.id\n" + 
    			"inner join rs_response response on response.questionid = question.id\n" + 
    			"where response.questionid = ?"  ,
	                new Object[] {preguntaId}, new BeanPropertyRowMapper<Respuesta>(Respuesta.class));
		 

    	return pr;
    }
    public List<Pregunta> getPreguntas(Integer areaId, Integer subAreaId){
    	List<Pregunta> pregunta =  jdbcTemplate.query("select distinct\n" + 
    			" --sub.id as id, sub.name as name\n" + 
    			" question.id as id, question.name as name\n" + 
    			"--, response.id as responseid, response.number as number, response.name as responsename\n" + 
    			"from rs_area_catalog area\n" + 
    			"inner join  rs_subarea_catalog sub on sub.areaid = area.id \n" + 
    			"inner join rs_question question on question.subareaid = sub.id\n" + 
    			"inner join rs_response response on response.questionid = question.id\n" + 
    			"where question.areaid = ? and question.subareaid = ?"  ,
	                new Object[] {areaId,subAreaId}, new BeanPropertyRowMapper<Pregunta>(Pregunta.class));
    	for(int x=0; x<pregunta.size(); x++) {
    		pregunta.get(x).setRespuesta(getRespuestas(pregunta.get(x).getId()));;
		}

    	return pregunta;
    }
    public List<SubArea> getSubAreas(Integer areaId){
    	List<SubArea> subareas =  jdbcTemplate.query("select distinct\n" + 
    			" sub.id as id, sub.name as name\n" + 
    			"--, question.id as questionid, question.name as questionname\n" + 
    			"--, response.id as responseid, response.number as number, response.name as responsename\n" + 
    			"from rs_area_catalog area\n" + 
    			"inner join  rs_subarea_catalog sub on sub.areaid = area.id \n" + 
    			"inner join rs_question question on question.subareaid = sub.id\n" + 
    			"inner join rs_response response on response.questionid = question.id\n" + 
    			"where sub.areaid = ?",
	                new Object[] {areaId}, new BeanPropertyRowMapper<SubArea>(SubArea.class));
    	for(int x=0; x<subareas.size(); x++) {
    		subareas.get(x).setPregunta(getPreguntas(areaId,subareas.get(x).getId()));;
		}
    	return subareas;
    }
	@Override
	public Encuesta getRows() {
		  Encuesta encuesta = new Encuesta();
	  try {
		List<Area> areas =  jdbcTemplate.query("select distinct area.id as id, area.name as name\n" + 
		  		"--, sub.id as subareaid, sub.name as subareaname\n" + 
		  		"--, question.id as questionid, question.name as questionname\n" + 
		  		"--, response.id as responseid, response.number as number, response.name as responsename\n" + 
		  		"from rs_area_catalog area\n" + 
		  		"inner join  rs_subarea_catalog sub on sub.areaid = area.id \n" + 
		  		"inner join rs_question question on question.subareaid = sub.id\n" + 
		  		"inner join rs_response response on response.questionid = question.id  ORDER BY area.id",
	                new Object[] {}, new BeanPropertyRowMapper<Area>(Area.class));
			for(int x=0; x<areas.size(); x++) {
				areas.get(x).setSubarea(getSubAreas(areas.get(x).getId()));
			}
			encuesta.setArea(areas);
			logger.info(objectMapper.writeValueAsString(encuesta));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        return encuesta;
	        
	}

	@Override
	public void removeRow(Integer id) {
		// TODO Auto-generated method stub
		final String sql = "UPDATE RS_QUESTION SET status = ?  WHERE id = ? ";
		jdbcTemplate.update(sql,
				0,id);
	}

	@Override
	public void addRow(Catalog p) {
		// TODO Auto-generated method stub
		final String sql = "INSERT INTO RS_QUESTION (id, name, status, createdAt,areaId,subareaId "+")  VALUES ( ?,?,?,?, ?,?)";
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
     	            pst.setInt(5, p.getAreaId());
     	            pst.setInt(6, p.getSubareaId());

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
			pr =	(Catalog) jdbcTemplate.queryForObject("select * from RS_QUESTION where id= ?  ",
	                new Object[] { id }, new BeanPropertyRowMapper<Catalog>(Catalog.class));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	        return pr;		}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		Integer pr =  (Integer) jdbcTemplate.queryForObject("select case when max(id) > 0 then max(id)+1 else 1 end as valor from RS_QUESTION ",
	                new Object[] { }, Integer.class);

	        return pr;
	}

}
