package com.spring.springajaxintegration.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.springajaxintegration.persistence.model.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Integer> {

	@Query("SELECT c.cityName From CityEntity c where c.stateEntity.stateName = :stateName")
	public List<String> getCityNamesForSelectedState(@Param("stateName") String stateName);
}
