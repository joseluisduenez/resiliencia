package com.binbit.resiliencia.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.binbit.resiliencia.dao.ActionKeywordDao;
import com.binbit.resiliencia.dto.KeywordModel;
import com.binbit.resiliencia.util.ActionType;
   
@Repository
public class ActionKeywordDaoImpl implements ActionKeywordDao{

    @Autowired
    JdbcTemplate jdbcTemplate;
    
	public List < KeywordModel > getSubscriptionKeywords() {
 		List<KeywordModel> keywordModel =  jdbcTemplate.query("select * from BNB_PREFIX_ACTION_KEYWORD where action_id = ? and carrier_id =1 ",
                new Object[] { ActionType.SUBSCRIBE }, new BeanPropertyRowMapper<KeywordModel>(KeywordModel.class));
     
            return keywordModel;
	}

	public List < KeywordModel >  getUnSubscriptionKeywords() {
		List<KeywordModel> keywordModel =   jdbcTemplate.query("select * from BNB_PREFIX_ACTION_KEYWORD where action_id = ? and carrier_id =1",
                new Object[] { ActionType.UNSUBSCRIBE }, new BeanPropertyRowMapper<KeywordModel>(KeywordModel.class));
     
            return keywordModel;
	}

	public List < KeywordModel >  getHelpKeywords() {
		List<KeywordModel> keywordModel =   jdbcTemplate.query("select * from BNB_PREFIX_ACTION_KEYWORD where action_id = ? and carrier_id =1",
                new Object[] { ActionType.HELP }, new BeanPropertyRowMapper<KeywordModel>(KeywordModel.class));
     
            return keywordModel;
	}

}
