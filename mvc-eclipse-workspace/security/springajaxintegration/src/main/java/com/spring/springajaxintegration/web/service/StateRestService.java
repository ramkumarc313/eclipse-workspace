package com.spring.springajaxintegration.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springajaxintegration.business.service.CityService;

@RestController
@RequestMapping("/example1")
public class StateRestService {

	@Autowired
	private CityService cityService;
	
	@RequestMapping(value = "getCitiesForSelectedState", method = RequestMethod.POST)
	public @ResponseBody List<String> getCitiesForSelectedState(@RequestParam(value = "state", required = true) String state) {
		System.out.print("in getcities method with stateName : "+state);
		List<String> cityList = new ArrayList<String>();
		cityList.add("Select City");
		//This way seems to be more dynamic for me no need to update the class if we add new state
		cityList.addAll(cityService.getCityNamesForSelectedState(state));
		
		return cityList;
	}
}
