package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.StateBean;
import com.google.gson.Gson;
import com.service.StateService;

@Controller
public class StateController {

    
    @Autowired
    private StateService stateService;
    private ModelAndView mav;

    @RequestMapping(value = "/loadCountry", method = RequestMethod.GET)
    public ModelAndView loadCountry() {

        mav = new ModelAndView();
        mav.addObject("countryList", stateService.listCountry());
        
        return mav;
    }

    @RequestMapping(value = "/loadStates/{countryId}", headers = "Accept=*/*", method = RequestMethod.GET)
    @ResponseBody
    public String loadStates(@PathVariable("countryId") Integer countryId) throws IllegalStateException {
          Gson gson=new Gson(); 
        //Specify the returning object you want here
       // return stateService.loadState(countryId);
          return gson.toJson(stateService.loadState(countryId));
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index()
	{
    	loadCountry();
		Map<String, Object> model = new HashMap<String, Object>();

	return mav;

	}

}

