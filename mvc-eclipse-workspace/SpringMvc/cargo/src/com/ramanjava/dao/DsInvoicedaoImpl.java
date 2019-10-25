package com.ramanjava.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ramanjava.bean.DeliveryStateBean;
import com.ramanjava.bean.DistrictBean;
import com.ramanjava.bean.DsInvoiceBean;

@Repository("dsInvoicedao")
public class DsInvoicedaoImpl implements DsInvoicedao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addDsInvoice(DsInvoiceBean dsInvoiceBean) {
		sessionFactory.getCurrentSession().saveOrUpdate(dsInvoiceBean);
		
	}
	@SuppressWarnings("unchecked")
	public List<DsInvoiceBean> getDsInvoices(){
		return(List<DsInvoiceBean>) sessionFactory.getCurrentSession().createCriteria(DsInvoiceBean.class).list();
		
	}
	public DsInvoiceBean getDsInvoice(int invoiceId) {
		return(DsInvoiceBean)sessionFactory.getCurrentSession().get(DsInvoiceBean.class,invoiceId);
	}
	public void deleteDsInvoice(int invoiceId) {
		
		sessionFactory.getCurrentSession().createQuery("DELETE FROM DsInvoiceBean WHERE invoice_Id = "+invoiceId).executeUpdate();
	}
	
	@SuppressWarnings("unchecked")	
	public List<DeliveryStateBean> getDsDeliveryStates() {
		// TODO Auto-generated method stub
		return(List<DeliveryStateBean>) sessionFactory.getCurrentSession().createCriteria(DeliveryStateBean.class).list();

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DistrictBean> getDistricts(Integer deliveryStateId) {
		// TODO Auto-generated method stub DistrictBean
		return(List<DistrictBean>) sessionFactory.getCurrentSession().createQuery("FROM DistrictBean d WHERE d.delivery_stateId = " + deliveryStateId).list();
	}
	

}
