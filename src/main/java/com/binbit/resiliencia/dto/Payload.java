package com.binbit.resiliencia.dto;

public class Payload {

	private String msisdn;
	private Integer service_id;
	private Integer carrier_id;
	private String msg_content;
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public Integer getService_id() {
		return service_id;
	}
	public void setService_id(Integer service_id) {
		this.service_id = service_id;
	}
	public Integer getCarrier_id() {
		return carrier_id;
	}
	public void setCarrier_id(Integer carrier_id) {
		this.carrier_id = carrier_id;
	}
	public String getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
 
	 
	
}
