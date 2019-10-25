package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.CountryBean;
import com.bean.StateBean;

@Repository
public class StateDaoImpl implements StateDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<CountryBean> listCountry(){

		return getCurrentSession().createQuery("from CountryBean").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StateBean> loadState(Integer countryId) {

		return getCurrentSession().createQuery("from StateBean s where s.countryId=" + countryId + ")").list();

	}


}
