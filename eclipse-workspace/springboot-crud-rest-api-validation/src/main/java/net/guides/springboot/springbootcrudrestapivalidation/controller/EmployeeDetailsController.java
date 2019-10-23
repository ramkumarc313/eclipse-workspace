package net.guides.springboot.springbootcrudrestapivalidation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot.springbootcrudrestapivalidation.exception.ResourceNotFoundException;
import net.guides.springboot.springbootcrudrestapivalidation.model.EmployeeDetails;
import net.guides.springboot.springbootcrudrestapivalidation.repository.EmployeeDetailsRepository;

@RestController
@RequestMapping("/api/v2")
public class EmployeeDetailsController {
	
	@Autowired
	private EmployeeDetailsRepository employeedetailsRepository;
	
	@GetMapping("/employeedetails")	
	public List<EmployeeDetails> getAllEmplyeeDetails(){
		
		return employeedetailsRepository.findAll();
	}
	
	@PostMapping("/employeedetails")
	public EmployeeDetails createEmployeDetails(@Valid @RequestBody EmployeeDetails employeeDetails)
	{
		
		return employeedetailsRepository.save(employeeDetails);
		
	}
	
	@GetMapping("/employeedetails/{id}")
	public ResponseEntity<EmployeeDetails> getEmployeeDetails(@PathVariable("id") Long employeId)
			throws ResourceNotFoundException{
		
		EmployeeDetails employee=employeedetailsRepository.findById(employeId)
				.orElseThrow(() -> new ResourceNotFoundException("EmployeeDetails not found for this id ::"+employeId));
		
		return ResponseEntity.ok().body(employee);
		
	}
	
	@PutMapping("/employeedetails/{id}")
	public ResponseEntity<EmployeeDetails> updateEmployeeDetails(@PathVariable("id") Long employeId,@Valid @RequestBody EmployeeDetails employeeDetails)throws ResourceNotFoundException {
		
		EmployeeDetails employee=employeedetailsRepository.findById(employeId)
				.orElseThrow(()-> new ResourceNotFoundException("EmployeeDetails not found for this id ::"+employeId));
		
		employee.setEmployeeId(employeeDetails.getEmployeeId());
		employee.setAdress(employeeDetails.getAdress());
		employee.setCity(employeeDetails.getCity());
		employee.setState(employeeDetails.getState());
		employee.setQualification(employeeDetails.getQualification());
		employee.setSalary(employeeDetails.getSalary());
		final EmployeeDetails updateEmployeeDetails=employeedetailsRepository.save(employee);

		return ResponseEntity.ok().body(updateEmployeeDetails);
		
		
	}
	
	@DeleteMapping("/employeedetails/{id}")
	public Map<String, Boolean> deleteEmployeeDetails(@PathVariable("id") Long employeId)
	throws ResourceNotFoundException{
		
		EmployeeDetails employee=employeedetailsRepository.findById(employeId)
				.orElseThrow(()->new ResourceNotFoundException("EmployeeDetails not found for this id"+employeId));
		
		employeedetailsRepository.delete(employee);
		Map<String, Boolean> maps=new HashMap<String, Boolean>();
		maps.put("deleted", Boolean.TRUE);
		
		
		return maps;
		
	}
	

}
