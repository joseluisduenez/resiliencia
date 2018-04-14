package com.binbit.resiliencia.dto.sms;

public class SubscriptionKannelDTO {
	private int shortCode;
	private String msisdn;
	private String text;
	private String textbin;
	private String smsc;
	private String idSmsc;
	private String delivery;
	private String mclass;
	private String udh;
	private String charset;
	private String billing;
	private String osmsc;
	private String metaData;
	
	public int getShortCode() {
		return shortCode;
	}
	public void setShortCode(int shortCode) {
		this.shortCode = shortCode;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTextbin() {
		return textbin;
	}
	public void setTextbin(String textbin) {
		this.textbin = textbin;
	}
	public String getSmsc() {
		return smsc;
	}
	public void setSmsc(String smsc) {
		this.smsc = smsc;
	}
	public String getIdSmsc() {
		return idSmsc;
	}
	public void setIdSmsc(String idSmsc) {
		this.idSmsc = idSmsc;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public String getMclass() {
		return mclass;
	}
	public void setMclass(String mclass) {
		this.mclass = mclass;
	}
	public String getUdh() {
		return udh;
	}
	public void setUdh(String udh) {
		this.udh = udh;
	}
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}
	public String getBilling() {
		return billing;
	}
	public void setBilling(String billing) {
		this.billing = billing;
	}
	public String getOsmsc() {
		return osmsc;
	}
	public void setOsmsc(String osmsc) {
		this.osmsc = osmsc;
	}
	public String getMetaData() {
		return metaData;
	}
	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}
	
}
