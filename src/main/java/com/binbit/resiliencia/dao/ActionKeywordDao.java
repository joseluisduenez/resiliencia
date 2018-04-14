package com.binbit.resiliencia.dao;

import java.util.List;

import com.binbit.resiliencia.dto.KeywordModel;

public interface ActionKeywordDao {

	public List < KeywordModel >  getSubscriptionKeywords();
	public List < KeywordModel >  getUnSubscriptionKeywords();
	public List < KeywordModel >  getHelpKeywords();
	
}
