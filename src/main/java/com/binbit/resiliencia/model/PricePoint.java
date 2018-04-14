package com.binbit.resiliencia.model;

public class PricePoint {

	private Integer id;
	private Integer carrierId;
	private Integer serviceId;
	private Integer pricePointId;
	private Double pricePointValue;
	private String currency;
	private Integer periodicityId;
	
	
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public Integer getPeriodicityId() {
		return periodicityId;
	}
	public void setPeriodicityId(Integer periodicityId) {
		this.periodicityId = periodicityId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(Integer carrierId) {
		this.carrierId = carrierId;
	}
 
	public Integer getPricePointId() {
		return pricePointId;
	}
	public void setPricePointId(Integer pricePointId) {
		this.pricePointId = pricePointId;
	}


	public Double getPricePointValue() {
		return pricePointValue;
	}
	public void setPricePointValue(Double pricePointValue) {
		this.pricePointValue = pricePointValue;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
