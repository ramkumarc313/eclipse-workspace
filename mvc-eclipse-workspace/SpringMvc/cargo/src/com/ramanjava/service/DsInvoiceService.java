package com.ramanjava.service;

import java.util.List;

import com.ramanjava.bean.DeliveryStateBean;
import com.ramanjava.bean.DistrictBean;
import com.ramanjava.bean.DsInvoiceBean;

public interface DsInvoiceService {

	public void addDsInvoice(DsInvoiceBean dsInvoiceBean);
	public List<DsInvoiceBean> getDsInvoices();	
	public DsInvoiceBean getDsInvoice(int invoiceId);	
	public void deleteDsInvoice(int invoiceId);
	public List<DeliveryStateBean> getDsDeliveryStates();	
	public List<DistrictBean> getDistricts(Integer deliveryStateId);	


}
