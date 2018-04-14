package com.binbit.resiliencia.dto;

import java.util.Date;

public abstract class BaseTransaction {

	private Integer id;
	private String text;
	private Date createdDate;
	private Date lastUpdateDate;
	private Integer shortCode;
	private String msisdn;
  	private String serviceName;
	private Integer subscriptionStatus;
	private Integer billingStatus;
	private String message;
	private String responseStatusTimweSubscriptionCode;
	private Integer mccmnc;
	private Integer promoId;
	private Integer seviceIdCarrier;
	private Integer serviceIdApiCore;
	private Integer serviceIdPromos;

	public Integer getServiceIdApiCore() {
		return serviceIdApiCore;
	}

	public void setServiceIdApiCore(Integer serviceIdApiCore) {
		this.serviceIdApiCore = serviceIdApiCore;
	}

	public Integer getServiceIdPromos() {
		return serviceIdPromos;
	}

	public void setServiceIdPromos(Integer serviceIdPromos) {
		this.serviceIdPromos = serviceIdPromos;
	}

	public Integer getSeviceIdCarrier() {
		return seviceIdCarrier;
	}

	public void setSeviceIdCarrier(Integer seviceIdCarrier) {
		this.seviceIdCarrier = seviceIdCarrier;
	}

	public Integer getPromoId() {
		return promoId;
	}
	public void setPromoId(Integer promoId) {
		this.promoId = promoId;
	}
	public Integer getMccmnc() {
		return mccmnc;
	}
	public void setMccmnc(Integer mccmnc) {
		this.mccmnc = mccmnc;
	}
	public String getResponseStatusTimweSubscriptionCode() {
		return responseStatusTimweSubscriptionCode;
	}
	public void setResponseStatusTimweSubscriptionCode(String responseStatusTimweSubscriptionCode) {
		this.responseStatusTimweSubscriptionCode = responseStatusTimweSubscriptionCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getSubscriptionStatus() {
		return subscriptionStatus;
	}
	public void setSubscriptionStatus(Integer subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}
	public Integer getBillingStatus() {
		return billingStatus;
	}
	public void setBillingStatus(Integer billingStatus) {
		this.billingStatus = billingStatus;
	}
 
	 
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Integer getShortCode() {
		return shortCode;
	}
	public void setShortCode(Integer shortCode) {
		this.shortCode = shortCode;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	
}
