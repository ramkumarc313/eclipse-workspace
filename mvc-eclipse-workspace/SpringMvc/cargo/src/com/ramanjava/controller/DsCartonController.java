package com.ramanjava.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ramanjava.bean.DsCartonBean;
import com.ramanjava.bean.DsInvoiceBean;
import com.ramanjava.service.DsCartonService;
import com.ramanjava.service.DsInvoiceService;

@Controller
@SessionAttributes("invoice")
public class DsCartonController {
	
	
	@Autowired
	private DsCartonService dsCartonService;
	
	@Autowired
	private DsInvoiceService dsInvoiceService;
	
	@ModelAttribute("invoice")
	   public DsInvoiceBean setUpUserForm() {
	      return new DsInvoiceBean();
	   }
	
	@RequestMapping(value = "/saveCarton", method = RequestMethod.POST)
	public ModelAndView saveInvoice(@ModelAttribute("command") DsCartonBean dscarton, 
			BindingResult result) {
		dsCartonService.addDsCarton(dscarton);
		return new ModelAndView("redirect:/addCarton.html");
	}
	
	@RequestMapping(value = "/addCarton", method = RequestMethod.GET)
	public ModelAndView addDsInvoice(@ModelAttribute("command")  DsCartonBean dscarton,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("dscartons",  dsCartonService.getDscartons());
		model.put("dsinvoices",  dsInvoiceService.getDsInvoices());
		return new ModelAndView("addCarton", model);
	}

	@RequestMapping(value="/dscartons", method = RequestMethod.GET)
	public List<DsCartonBean> getDscartons() {
		return dsCartonService.getDscartons();
	}
	
	
	@RequestMapping(value = "/editCarton", method = RequestMethod.GET)
	public ModelAndView editCarton(@ModelAttribute("command")  DsCartonBean dscarton,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("dscarton", dsCartonService.getDsCarton(dscarton.getCartonId()));
		model.put("dscartons",  dsCartonService.getDscartons());
		model.put("dsinvoices",  dsInvoiceService.getDsInvoices());
		return new ModelAndView("addCarton", model);
	}
	
	@RequestMapping(value = "/deleteCarton", method = RequestMethod.GET)
	public ModelAndView deleteCarton(@ModelAttribute("command")  DsCartonBean dscarton,
			BindingResult result) {
		dsCartonService.deleteDsCarton(dscarton.getCartonId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("dscartons",  dsCartonService.getDscartons());
		model.put("dsinvoices",  dsInvoiceService.getDsInvoices());
		return new ModelAndView("addCarton", model);
	}
}
