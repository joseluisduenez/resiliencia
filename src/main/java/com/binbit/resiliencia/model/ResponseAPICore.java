package com.binbit.resiliencia.model;

public class ResponseAPICore {

	private String redirection;
	private SubscriptionAPICoreResponse subscription;
	private Bill bill;
 	
	
	 
	public String getRedirection() {
		return redirection;
	}
	public void setRedirection(String redirection) {
		this.redirection = redirection;
	}
	 
	public SubscriptionAPICoreResponse getSubscription() {
		return subscription;
	}
	public void setSubscription(SubscriptionAPICoreResponse subscription) {
		this.subscription = subscription;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public class SubscriptionAPICoreResponse{
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
	public class Bill{
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
}
