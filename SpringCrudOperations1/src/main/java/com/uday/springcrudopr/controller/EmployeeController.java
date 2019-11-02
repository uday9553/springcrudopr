package com.uday.springcrudopr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uday.springcrudopr.entity.EEmployeeIdentity;
import com.uday.springcrudopr.model.Employee;
import com.uday.springcrudopr.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> fetchAll(){
		return employeeService.fetchAll();
	}
	@GetMapping("/getempames")
	public ResponseEntity<List<String>> getEmpNames(){
		return employeeService.getEmpNames();
	}
	@GetMapping("/getempame/{id}")
	public ResponseEntity<List<Employee>> getEmpName(@PathVariable("id") String id){
		return employeeService.getEmpName(id);
	}
	public Employee getEmployee(@RequestBody EEmployeeIdentity eEmployeeIdentity) {
		return null;
	}
}
 