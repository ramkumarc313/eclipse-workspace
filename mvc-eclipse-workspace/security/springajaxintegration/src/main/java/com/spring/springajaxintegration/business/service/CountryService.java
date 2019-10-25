package com.spring.springajaxintegration.business.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.springajaxintegration.persistence.model.CountryEntity;
import com.spring.springajaxintegration.persistence.repository.CountryRepository;

@Service
public class CountryService {

	@PersistenceContext(unitName = "hibernatePersistenceUnit")
	private EntityManager entityManager;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<CountryEntity> getListOfCountries() {
		return countryRepository.getListOfCountries();
	}
	
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public CountryEntity getCountryDetails(@Param("countryName") String countryName) {
		return countryRepository.getCountryDetails(countryName);
	}
}
