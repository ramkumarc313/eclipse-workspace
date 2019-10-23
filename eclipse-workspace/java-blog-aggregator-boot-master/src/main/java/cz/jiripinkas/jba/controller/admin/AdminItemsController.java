package cz.jiripinkas.jba.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.jiripinkas.jba.service.ItemService;

@Controller
public class AdminItemsController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("/admin/items/toggle-enabled/{id}")
	@ResponseBody
	public String toggleEnabled(@PathVariable int id) {
		boolean enabled = itemService.toggleEnabled(id);
		return Boolean.toString(enabled);
	}
}
