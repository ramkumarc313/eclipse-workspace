package com.ramanjava.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ramanjava.bean.DsCartonBean;

@Repository("dsCartondao")
public class DsCartondaoImpl implements DsCartondao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addDsCarton(DsCartonBean dsCarton) {
		sessionFactory.getCurrentSession().saveOrUpdate(dsCarton);
	}
	@SuppressWarnings("unchecked")
	public List<DsCartonBean> getDscartons(){
		
		return(List<DsCartonBean>)sessionFactory.getCurrentSession().createCriteria(DsCartonBean.class).list();
	}
	
	
	public DsCartonBean getDsCarton(int cartonId)
	{
		return(DsCartonBean) sessionFactory.getCurrentSession().get(DsCartonBean.class, cartonId);
	}
	public void deleteDsCarton(int cartonId) {
		sessionFactory.getCurrentSession().createQuery("Delete from DsCartonBean where carton_id= "+cartonId).executeUpdate();
	}

}
