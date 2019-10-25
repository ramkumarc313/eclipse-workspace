package com.tutorialspoint;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView student() {
		return new ModelAndView("student", "command", new Student());
	}
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("SpringWeb")Student student, 

			ModelMap model) {
		model.addAttribute("studentName", student.getName());
		model.addAttribute("studentAge", student.getAge());
		model.addAttribute("studentId", student.getId());

		return "result";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView student1() {
		return new ModelAndView("student", "command", new Student());
	}
}
