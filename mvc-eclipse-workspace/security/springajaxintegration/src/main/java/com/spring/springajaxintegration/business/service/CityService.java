package com.spring.springajaxintegration.business.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.springajaxintegration.persistence.repository.CityRepository;

@Service
public class CityService {

	@PersistenceContext(unitName = "hibernatePersistenceUnit")
	private EntityManager entityManager;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<String> getCityNamesForSelectedState(String stateName) {
		return cityRepository.getCityNamesForSelectedState(stateName);
	}	
}