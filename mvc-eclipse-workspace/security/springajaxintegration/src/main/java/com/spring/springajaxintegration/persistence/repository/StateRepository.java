package com.spring.springajaxintegration.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.springajaxintegration.persistence.model.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, Integer> {

	@Query("SELECT s from StateEntity s ORDER BY s.stateName ASC")
	public List<StateEntity> getAllStates();
}
