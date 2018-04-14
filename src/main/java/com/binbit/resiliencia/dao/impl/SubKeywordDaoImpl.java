package com.binbit.resiliencia.dao.impl;

import com.binbit.resiliencia.dao.SubKeywordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SubKeywordDaoImpl implements SubKeywordDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Integer getIdService(String keyword) {
        Integer bill = jdbcTemplate.queryForObject("select service_id from BNB_SERVICE_SUB_KEYWORD where keyword_name =  ? ",
                new Object[] { keyword.trim() }, Integer.class);

        return bill;

    }
}
