package com.app.resiliencia.dto.sms;

public class KannelDTO {

	private int from;
	private String to;
	private String text;
	private String deliveryReportMask;
	private String deliveryReportUrl;
	
	
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDeliveryReportMask() {
		return deliveryReportMask;
	}
	public void setDeliveryReportMask(String deliveryReportMask) {
		this.deliveryReportMask = deliveryReportMask;
	}
	public String getDeliveryReportUrl() {
		return deliveryReportUrl;
	}
	public void setDeliveryReportUrl(String deliveryReportUrl) {
		this.deliveryReportUrl = deliveryReportUrl;
	}
}
