package com.binbit.resiliencia.dto;

public class KeywordModel {

	private String 	service;
	private int 	actionId;
	private String  keywordName;
	private boolean valid	=	false;
 	private boolean isArabic	=	false;


	public boolean isArabic() {
		return isArabic;
	}

	public void setArabic(boolean arabic) {
		isArabic = arabic;
	}

	public String getKeywordName() {
		return keywordName;
	}
	public void setKeywordName(String keywordName) {
		this.keywordName = keywordName;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
 
	public int getActionId() {
		return actionId;
	}
	public void setActionId(int actionId) {
		this.actionId = actionId;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
