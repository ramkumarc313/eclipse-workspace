package com.spring.springajaxintegration.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springajaxintegration.business.service.CountryService;
import com.spring.springajaxintegration.persistence.model.CountryEntity;

@RestController
@RequestMapping("/example2")
public class CountryRestService {

	@Autowired
	private CountryService countryService;

	@RequestMapping(value = "getCountryDetails", method = RequestMethod.POST)
	public @ResponseBody CountryEntity getCountryDetails(
			@RequestParam(value = "country", required = true) String countryName) {
		CountryEntity countryEntity = countryService
				.getCountryDetails(countryName);
		return countryEntity;
	}
}
