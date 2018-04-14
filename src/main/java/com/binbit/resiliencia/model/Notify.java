package com.binbit.resiliencia.model;

public class Notify {

	private String msisdn;
	private Integer carrier;
	private Integer attempt;
	private SubscriptionNotify subscription;
	private BillNotify bill;
	private String redirection;
	
	
	public String getRedirection() {
		return redirection;
	}
	public void setRedirection(String redirection) {
		this.redirection = redirection;
	}
	public SubscriptionNotify getSubscription() {
		return subscription;
	}
	public void setSubscription(SubscriptionNotify subscription) {
		this.subscription = subscription;
	}
	public BillNotify getBill() {
		return bill;
	}
	public void setBill(BillNotify bill) {
		this.bill = bill;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public Integer getCarrier() {
		return carrier;
	}
	public void setCarrier(Integer carrier) {
		this.carrier = carrier;
	}
	public Integer getAttempt() {
		return attempt;
	}
	public void setAttempt(Integer attempt) {
		this.attempt = attempt;
	}
	public class SubscriptionNotify{
		private Integer code;
		private String message;
		public Integer getCode() {
			return code;
		}
		public void setCode(Integer code) {
			this.code = code;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
	}
	public class BillNotify{
		private Integer code;
		private String message;
		
		public BillNotify() {
			
		}
		public Integer getCode() {
			return code;
		}
		public void setCode(Integer code) {
			this.code = code;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
	}
}
