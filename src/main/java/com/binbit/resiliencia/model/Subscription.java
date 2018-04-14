package com.binbit.resiliencia.model;

public class Subscription {
	private Long serviceId;
	private String msisdn;
	private Integer shortCode;
	private String keyword;
	private Long mccMnc;
	private Integer mediaId;
	private Integer promoId;
	private String origin;
	private String externalServiceId;
	private String externalSubServiceId;
	private String externalSubscriptionId;
	private String nextBillDate;
	private String tsRegister;
	private Integer code;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Long getServiceId() {
		return serviceId;
	}
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public Integer getShortCode() {
		return shortCode;
	}
	public void setShortCode(Integer shortCode) {
		this.shortCode = shortCode;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Long getMccMnc() {
		return mccMnc;
	}
	public void setMccMnc(Long mccMnc) {
		this.mccMnc = mccMnc;
	}
	public Integer getMediaId() {
		return mediaId;
	}
	public void setMediaId(Integer mediaId) {
		this.mediaId = mediaId;
	}
	public Integer getPromoId() {
		return promoId;
	}
	public void setPromoId(Integer promoId) {
		this.promoId = promoId;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getExternalServiceId() {
		return externalServiceId;
	}
	public void setExternalServiceId(String externalServiceId) {
		this.externalServiceId = externalServiceId;
	}
	public String getExternalSubServiceId() {
		return externalSubServiceId;
	}
	public void setExternalSubServiceId(String externalSubServiceId) {
		this.externalSubServiceId = externalSubServiceId;
	}
	public String getExternalSubscriptionId() {
		return externalSubscriptionId;
	}
	public void setExternalSubscriptionId(String externalSubscriptionId) {
		this.externalSubscriptionId = externalSubscriptionId;
	}
	public String getNextBillDate() {
		return nextBillDate;
	}
	public void setNextBillDate(String nextBillDate) {
		this.nextBillDate = nextBillDate;
	}
	public String getTsRegister() {
		return tsRegister;
	}
	public void setTsRegister(String tsRegister) {
		this.tsRegister = tsRegister;
	}
	
	
}
