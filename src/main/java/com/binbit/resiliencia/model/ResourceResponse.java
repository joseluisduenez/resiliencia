package com.binbit.resiliencia.model;

public class ResourceResponse {

	private String code;
	private String description;
	private String correlator;
	private String msisdn;
	private Otp otp;
	private Subscription subscription;
	
	
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

 

	public String getCorrelator() {
		return correlator;
	}

	public void setCorrelator(String correlator) {
		this.correlator = correlator;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public Otp getOtp() {
		return otp;
	}

	public void setOtp(Otp otp) {
		this.otp = otp;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public class Subscription{
		private String msisdn;
		private String opId;
		private String responseStatusCode;
		private String responseStatusDescription;
		private String serviceId;
		private String productId;
		private String clubId;
		private String subid;
		private String subStatus;
		public Subscription() {}
		public String getMsisdn() {
			return msisdn;
		}
		public void setMsisdn(String msisdn) {
			this.msisdn = msisdn;
		}
		public String getOpId() {
			return opId;
		}
		public void setOpId(String opId) {
			this.opId = opId;
		}
		public String getResponseStatusCode() {
			return responseStatusCode;
		}
		public void setResponseStatusCode(String responseStatusCode) {
			this.responseStatusCode = responseStatusCode;
		}
		public String getResponseStatusDescription() {
			return responseStatusDescription;
		}
		public void setResponseStatusDescription(String responseStatusDescription) {
			this.responseStatusDescription = responseStatusDescription;
		}
		public String getServiceId() {
			return serviceId;
		}
		public void setServiceId(String serviceId) {
			this.serviceId = serviceId;
		}
		public String getProductId() {
			return productId;
		}
		public void setProductId(String productId) {
			this.productId = productId;
		}
		public String getClubId() {
			return clubId;
		}
		public void setClubId(String clubId) {
			this.clubId = clubId;
		}
		public String getSubid() {
			return subid;
		}
		public void setSubid(String subid) {
			this.subid = subid;
		}
		public String getSubStatus() {
			return subStatus;
		}
		public void setSubStatus(String subStatus) {
			this.subStatus = subStatus;
		}
		
		
		
	}
	
	public class Otp{
		private String status;
		private String description;
		public Otp() {}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		
	}
}
