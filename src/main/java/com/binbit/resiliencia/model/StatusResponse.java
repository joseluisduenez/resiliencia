package com.binbit.resiliencia.model;

public class StatusResponse {

	private boolean allowed;
	private Subscription subscription;
	
	
	
	public Subscription getSubscription() {
		return subscription;
	}



	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}



	public boolean isAllowed() {
		return allowed;
	}



	public void setAllowed(boolean allowed) {
		this.allowed = allowed;
	}




}
