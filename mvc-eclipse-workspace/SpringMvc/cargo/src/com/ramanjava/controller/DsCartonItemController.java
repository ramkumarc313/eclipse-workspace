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
import org.springframework.web.servlet.ModelAndView;

import com.ramanjava.bean.DsCartonItemBean;
import com.ramanjava.service.DsCartonItemService;
import com.ramanjava.service.DsCartonService;

@Controller
public class DsCartonItemController {

	@Autowired
	private DsCartonItemService dsCartonItemService;
	
	@Autowired
	private DsCartonService dsCartonService;
	
	@RequestMapping(value = "/saveCartonItem", method = RequestMethod.POST)
	public ModelAndView saveCartonItem(@ModelAttribute("command") DsCartonItemBean dscartonItem, 
			BindingResult result) {
		dsCartonItemService.addDsCartonItem(dscartonItem);
		return new ModelAndView("redirect:/addCartonItem.html");
	}
	
	
	@RequestMapping(value = "/addCartonItem", method = RequestMethod.GET)
	public ModelAndView addDsCartonItem(@ModelAttribute("command")  DsCartonItemBean dscartonItem,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("dscartonitems",  dsCartonItemService.getDscartonItems());
		model.put("dscartons",  dsCartonService.getDscartons());
		return new ModelAndView("addCartonItem", model);
	}
	
	@RequestMapping(value="/dscartonitems", method = RequestMethod.GET)
	public List<DsCartonItemBean> getDscartons() {
		return dsCartonItemService.getDscartonItems();
	}
	
	
	@RequestMapping(value = "/editCartonItem", method = RequestMethod.GET)
	public ModelAndView editCartonItem(@ModelAttribute("command")  DsCartonItemBean dscartonItem,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("dscartonItem", dsCartonItemService.getDsCartonItem(dscartonItem.getCartonItemid()));
		model.put("dscartonitems",  dsCartonItemService.getDscartonItems());
		model.put("dscartons",  dsCartonService.getDscartons());
		return new ModelAndView("addCartonItem", model);
	}
	
	@RequestMapping(value = "/deleteCartonItem", method = RequestMethod.GET)
	public ModelAndView deleteCartonItem(@ModelAttribute("command")  DsCartonItemBean dscartonItem,
			BindingResult result) {
		dsCartonItemService.deleteDsCartonItem(dscartonItem.getCartonItemid());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("dscartonitems",  dsCartonItemService.getDscartonItems());
		model.put("dscartons",  dsCartonService.getDscartons());
		return new ModelAndView("addCartonItem", model);
	}
}
