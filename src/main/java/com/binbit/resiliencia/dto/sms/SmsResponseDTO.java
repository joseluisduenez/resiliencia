package com.binbit.resiliencia.dto.sms;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "sms-success")
public class SmsResponseDTO {

	private String code;
	private String message;
	
	public SmsResponseDTO() {
	       super();
	}
	 
	public SmsResponseDTO(final String code, final String message) {
	       this.setCode(code);
	       this.setMessage(message);
	}
	public String getCode() {
		return code;
	}
	@XmlElement
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	@XmlElement
	public void setMessage(String message) {
		this.message = message;
	}
}
