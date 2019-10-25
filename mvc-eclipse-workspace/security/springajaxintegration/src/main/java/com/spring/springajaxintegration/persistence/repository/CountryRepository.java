package com.spring.springajaxintegration.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.springajaxintegration.persistence.model.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {

	@Query("SELECT c FROM COUNTRY c ORDER BY c.countryName ASC")
	public List<CountryEntity> getListOfCountries();
	
	@Query("SELECT c FROM COUNTRY c WHERE c.countryName = :countryName")
	public CountryEntity getCountryDetails(@Param("countryName") String countryName);
}
