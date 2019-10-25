package com.ramanjava.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import com.ramanjava.bean.CustomForm;
import com.ramanjava.bean.DeliveryStateBean;
import com.ramanjava.bean.DistrictBean;
import com.ramanjava.bean.DsInvoiceBean;
import com.ramanjava.bean.StateCreateria;
import com.ramanjava.service.DsInvoiceService;

@Controller
@RestController
@SessionAttributes("invoice")
public class DsInvoiceController {

	@Autowired
	private DsInvoiceService dsInvoiceService;

	@ModelAttribute("invoice")
	   public DsInvoiceBean setUpUserForm() {
	      return new DsInvoiceBean();
	   }

	@RequestMapping(value = "/saveInvoice", method = RequestMethod.POST)
	public ModelAndView saveInvoice(@ModelAttribute("command") DsInvoiceBean dsInvoice, 
			BindingResult result) {
		dsInvoiceService.addDsInvoice(dsInvoice);

		return new ModelAndView("redirect:/addDsinvoice.html");
	}

	@RequestMapping(value = "/addDsinvoice", method = RequestMethod.GET)
	public ModelAndView addDsInvoice(@ModelAttribute("command")  DsInvoiceBean dsInvoice,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("dsinvoices",  dsInvoiceService.getDsInvoices());
		return new ModelAndView("addDsinvoice", model);
	}

	@RequestMapping(value="/dsinvoices", method = RequestMethod.GET)
	public List<DsInvoiceBean> getDsInvoices() {
		return dsInvoiceService.getDsInvoices();
	}

	@ModelAttribute("dsStates")
	public List<DeliveryStateBean> getDsstates() {
		 //System.out.println(dsInvoiceService.getDsDeliveryStates());
		//Map<String, Object> model = new HashMap<String, Object>();
		// model.put("districts",  dsInvoiceService.getDistricts(deliverySate.getDeliverySateId()));

		return dsInvoiceService.getDsDeliveryStates();
	}

	
    @RequestMapping(value = "/districts", headers="Accept=application/json", method = RequestMethod.GET)
	public @ResponseBody
	List<DistrictBean> getDistricts(@RequestBody StateCreateria countryCriteria) 
	{
	
		  List<DistrictBean> districts = dsInvoiceService.getDistricts(countryCriteria.getDeliverySateId());
		  
		 // return cities;
		return districts;
	}

	@RequestMapping(value = "/editInvoice", method = RequestMethod.GET)
	public ModelAndView editCategory(@ModelAttribute("command")  DsInvoiceBean dsInvoice,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("dsInvoice", dsInvoiceService.getDsInvoice(dsInvoice.getInvoiceId()));
		model.put("dsinvoices",  dsInvoiceService.getDsInvoices());
		return new ModelAndView("addDsinvoice", model);
	}


	@RequestMapping(value = "/deleteInvoice", method = RequestMethod.GET)
	public ModelAndView deleteCategory(@ModelAttribute("command")  DsInvoiceBean dsInvoice,
			BindingResult result) {
		dsInvoiceService.deleteDsInvoice(dsInvoice.getInvoiceId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("dsinvoices",  dsInvoiceService.getDsInvoices());
		return new ModelAndView("addDsinvoice", model);
	}
	
	 @RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	 public ModelAndView home() {
	  ModelAndView model = new ModelAndView();
	  
	  CustomForm customForm = new CustomForm();
	  List<DeliveryStateBean> countries = dsInvoiceService.getDsDeliveryStates();
	  List<DistrictBean> cities = new ArrayList<DistrictBean>();
	  
	  model.addObject("countries", countries);
	  model.addObject("cities", cities);
	  model.addObject("customForm", customForm);
	  
	  model.setViewName("cargo/saveInvoice.html");
	  return model;
	 }
	 
	/* @RequestMapping(value = "/loadCityByCountry", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody List<DistrictBean> loadCityByCountry(@RequestBody StateCreateria countryCriteria) {
	  List<DistrictBean> cities = dsInvoiceService.getDistricts(countryCriteria.getDeliverySateId());
	  
	  return cities;
	 }*/



}
