package com.binbit.resiliencia.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseTIMWEAPI {

	public String msisdn;

	public String opid;
	@XmlElement(name = "responsestatus")
	public ResponseStatusTIMWEAPI status;
	@XmlElement(name = "service")
	ServiceTIMWEAPI service;
	
	 
	public ServiceTIMWEAPI getService() {
		return service;
	}
	public void setService(ServiceTIMWEAPI service) {
		this.service = service;
	}
	public ResponseStatusTIMWEAPI getStatus() {
		return status;
	}
	public void setStatus(ResponseStatusTIMWEAPI status) {
		this.status = status;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getOpid() {
		return opid;
	}
	public void setOpid(String opid) {
		this.opid = opid;
	}
	
	
	
}
