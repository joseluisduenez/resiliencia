package com.binbit.resiliencia.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="subscribe-response")
public class SubscribeResponseTimweApi {

   	ResponseTIMWEAPI response;
   	
	@XmlElement(name = "response")
	public ResponseTIMWEAPI getResponse() {
		return response;
	}
 
	public void setResponse(ResponseTIMWEAPI response) {
		this.response = response;
	} 
	
	
	
}
