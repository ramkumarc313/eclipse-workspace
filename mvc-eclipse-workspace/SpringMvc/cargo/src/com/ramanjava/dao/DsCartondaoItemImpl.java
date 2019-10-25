package com.ramanjava.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ramanjava.bean.DsCartonItemBean;

@Repository("dsCartonItemdao")
public class DsCartondaoItemImpl implements DsCartonItemdao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addDsCartonItem(DsCartonItemBean dsCartonItem) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(dsCartonItem);
	}
	
	@SuppressWarnings("unchecked")
	public List<DsCartonItemBean> getDscartonItems(){
		
		return (List<DsCartonItemBean>) sessionFactory.getCurrentSession().createCriteria(DsCartonItemBean.class).list();
		
	}
	public DsCartonItemBean getDsCartonItem(int cartonItemId) {
		return (DsCartonItemBean)sessionFactory.getCurrentSession().get(DsCartonItemBean.class, cartonItemId);
		
	}
	public void deleteDsCartonItem(int cartonItemId) {
		sessionFactory.getCurrentSession().createQuery("Delete from DsCartonItemBean where cartonitem_id= "+cartonItemId).executeUpdate();

		
	}

}
