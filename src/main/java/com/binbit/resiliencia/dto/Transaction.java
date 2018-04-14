package com.binbit.resiliencia.dto;

import java.util.Date;

import com.binbit.resiliencia.model.Product;

public class Transaction extends BaseTransaction{ 
	private Product product;
	private KeywordModel keywordModel;
	private Integer billattemps;
	private Integer periodicityId;
	private Double billAmount;
	private Date lastDateAttemp;
	private Integer serviceId;
	private String channel;
	private String optInType;
	private String imgUrl;
	private Integer productId;
	private Integer pricepointId;
	private Boolean billed;
	private String codeResponseTIMWESubscription;
	private String urlPromos;
	private String urlPortal;
	private Integer type;
	private Boolean newSubscriber;
	private String correlatorId;
	private String attempId;
	private String	data;
	private Integer step;

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getAttempId() {
		return attempId;
	}

	public void setAttempId(String attempId) {
		this.attempId = attempId;
	}

	public String getCorrelatorId() {
		return correlatorId;
	}

	public void setCorrelatorId(String correlatorId) {
		this.correlatorId = correlatorId;
	}

	public Boolean getNewSubscriber() {
		return newSubscriber;
	}

	public void setNewSubscriber(Boolean newSubscriber) {
		this.newSubscriber = newSubscriber;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUrlPortal() {
		return urlPortal;
	}

	public void setUrlPortal(String urlPortal) {
		this.urlPortal = urlPortal;
	}

	public String getUrlPromos() {
		return urlPromos;
	}

	public void setUrlPromos(String urlPromos) {
		this.urlPromos = urlPromos;
	}

	public String getCodeResponseTIMWESubscription() {
		return codeResponseTIMWESubscription;
	}

	public void setCodeResponseTIMWESubscription(String codeResponseTIMWESubscription) {
		this.codeResponseTIMWESubscription = codeResponseTIMWESubscription;
	}

	public Boolean getBilled() {
		return billed;
	}

	public void setBilled(Boolean billed) {
		this.billed = billed;
	}

	public Integer getPricepointId() {
		return pricepointId;
	}

	public void setPricepointId(Integer pricepointId) {
		this.pricepointId = pricepointId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getOptInType() {
		return optInType;
	}

	public void setOptInType(String optInType) {
		this.optInType = optInType;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Date getLastDateAttemp() {
		return lastDateAttemp;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public void setLastDateAttemp(Date lastDateAttemp) {
		this.lastDateAttemp = lastDateAttemp;
	}

	public Double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}

	public KeywordModel getKeywordModel() {
		return keywordModel;
	}

	public void setKeywordModel(KeywordModel keywordModel) {
		this.keywordModel = keywordModel;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

 

	public Integer getBillattemps() {
		return billattemps;
	}

	public void setBillattemps(Integer billattemps) {
		this.billattemps = billattemps;
	}

	public Integer getPeriodicityId() {
		return periodicityId;
	}

	public void setPeriodicityId(Integer periodicityId) {
		this.periodicityId = periodicityId;
	}

 
	
	
}
