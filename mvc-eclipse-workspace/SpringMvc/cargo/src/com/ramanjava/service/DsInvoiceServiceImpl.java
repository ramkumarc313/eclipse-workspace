package com.ramanjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ramanjava.bean.DeliveryStateBean;
import com.ramanjava.bean.DistrictBean;
import com.ramanjava.bean.DsInvoiceBean;
import com.ramanjava.dao.DsInvoicedao;

@Service("dsInvoiceService") 
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DsInvoiceServiceImpl implements DsInvoiceService {
	
	@Autowired
	private DsInvoicedao dsInvoicedao1;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addDsInvoice(DsInvoiceBean dsInvoiceBean) {
		dsInvoicedao1.addDsInvoice(dsInvoiceBean);
	}
	public List<DsInvoiceBean> getDsInvoices(){
		
		return dsInvoicedao1.getDsInvoices();
	}
	public DsInvoiceBean getDsInvoice(int invoiceId) {
		
		return dsInvoicedao1.getDsInvoice(invoiceId);
	}
	public void deleteDsInvoice(int invoiceId) {
		 dsInvoicedao1.deleteDsInvoice(invoiceId);
	}
	
	@Override
	public List<DeliveryStateBean> getDsDeliveryStates() {
		// TODO Auto-generated method stub
	//	System.out.println(dsInvoicedao1.getDsDeliveryStates());

		return dsInvoicedao1.getDsDeliveryStates();
	}
	
	@Override
	public List<DistrictBean> getDistricts(Integer deliveryStateId) {
		// TODO Auto-generated method stub
		return dsInvoicedao1.getDistricts(deliveryStateId);
	}

}
