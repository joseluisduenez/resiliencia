package com.binbit.resiliencia.dao;

import com.binbit.resiliencia.model.BillAttemp;

public interface BillAttempDao {

	public BillAttemp createBillAtempEntity(BillAttemp billAttemp);
	public BillAttemp getBillAttempByCreationDate(BillAttemp billAttemp);
	public BillAttemp updateBillAttemp(BillAttemp billAttemp);

}
