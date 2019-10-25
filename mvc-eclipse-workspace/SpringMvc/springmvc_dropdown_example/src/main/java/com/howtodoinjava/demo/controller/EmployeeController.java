package com.howtodoinjava.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.howtodoinjava.demo.editors.DepartmentEditor;
import com.howtodoinjava.demo.model.DepartmentVO;
import com.howtodoinjava.demo.model.EmployeeVO;
import com.howtodoinjava.demo.service.EmployeeManager;

@Controller
@RequestMapping("/employee-module/addNew")
@SessionAttributes("employee")
public class EmployeeController
{
	@Autowired
	EmployeeManager manager;

	private Validator validator;

	public EmployeeController()
	{
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(DepartmentVO.class, new DepartmentEditor());
    }
	
	@ModelAttribute("allDepartments")
    public List<DepartmentVO> populateDepartments() 
    {
        ArrayList<DepartmentVO> departments = new ArrayList<DepartmentVO>();
        departments.add(new DepartmentVO(-1,  "Select Department"));
        departments.add(new DepartmentVO(1,  "Human Resource"));
        departments.add(new DepartmentVO(2,  "Finance"));
        departments.add(new DepartmentVO(3,  "Information Technology"));
        return departments;
    }

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		EmployeeVO employeeVO = new EmployeeVO();
		model.addAttribute("employee", employeeVO);
		return "addEmployee";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("employee") EmployeeVO employeeVO,
			BindingResult result, SessionStatus status) {

		Set<ConstraintViolation<EmployeeVO>> violations = validator.validate(employeeVO);
		
		for (ConstraintViolation<EmployeeVO> violation : violations) 
		{
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            // Add JSR-303 errors to BindingResult
            // This allows Spring to display them in view via a FieldError
            result.addError(new FieldError("employee", propertyPath, "Invalid "+ propertyPath + "(" + message + ")"));
        }

		if (result.hasErrors()) {
			return "addEmployee";
		}
		// Store the employee information in database
		// manager.createNewRecord(employeeVO);
		
		System.out.println(employeeVO);

		// Mark Session Complete
		status.setComplete();
		return "redirect:addNew/success";
	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String success(Model model) {
		return "addSuccess";
	}
}