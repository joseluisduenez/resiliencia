package com.binbit.resiliencia.dao;

 
import com.binbit.resiliencia.model.PartnerDetails;


public interface PartnerDetailsDao {

	public PartnerDetails getPartnerDetailsByCarrierName(String name);
}
