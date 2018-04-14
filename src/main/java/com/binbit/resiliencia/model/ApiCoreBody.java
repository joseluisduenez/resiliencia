package com.binbit.resiliencia.model;

public class ApiCoreBody {

	private String msisdn;
	private Integer serviceId;
	private Integer mccMnc;
	private Integer shortCode;
	private String text;
	private String tsRegister;
	private String carrierCode;
	private String carrierMessage;
	
	
	public String getCarrierCode() {
		return carrierCode;
	}
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	public String getCarrierMessage() {
		return carrierMessage;
	}
	public void setCarrierMessage(String carrierMessage) {
		this.carrierMessage = carrierMessage;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public Integer getMccMnc() {
		return mccMnc;
	}
	public void setMccMnc(Integer mccMnc) {
		this.mccMnc = mccMnc;
	}
	public Integer getShortCode() {
		return shortCode;
	}
	public void setShortCode(Integer shortCode) {
		this.shortCode = shortCode;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTsRegister() {
		return tsRegister;
	}
	public void setTsRegister(String tsRegister) {
		this.tsRegister = tsRegister;
	}
	
	
	
}
