package com.binbit.resiliencia.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)

public class ServiceTIMWEAPI {
	
	@XmlElement(name = "product")
	ProductTIMWEAPI product;

	public ProductTIMWEAPI getProduct() {
		return product;
	}

	public void setProduct(ProductTIMWEAPI product) {
		this.product = product;
	}
	
	
}
