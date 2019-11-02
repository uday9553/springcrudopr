package com.uday.springcrudopr.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uday.springcrudopr.entity.EEmployee;
import com.uday.springcrudopr.entity.EEmployeeIdentity;
import com.uday.springcrudopr.exception.EntityNotFoundException;
import com.uday.springcrudopr.model.Employee;
import com.uday.springcrudopr.repository.EmployeeRepository;
import com.uday.springcrudopr.transformer.EmployeeTransformer;
@Service
public class EmployeeService {
	private EmployeeRepository employeeRepository;
	private EmployeeTransformer employeeTransformer;
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository,EmployeeTransformer employeeTransformer){
		this.employeeRepository=employeeRepository;
		this.employeeTransformer=employeeTransformer;
	}
	public ResponseEntity<List<Employee>> fetchAll(){
		List<EEmployee> eEmployees= employeeRepository.findAll();
		List<Employee> employeeList=eEmployees
				.stream()
				.map(employeeTransformer.convertToEmployee())
				.collect(Collectors.toList());
		return ResponseEntity.ok(employeeList);
		
	}
	public  ResponseEntity<List<String>> getEmpNames(){
		List<EEmployee> eEmployees= employeeRepository.findAll();
		if(eEmployees.isEmpty()) {
			System.out.println("empty");
			throw new EntityNotFoundException("");
			
		}	
		List<String> allEmployeeNames=eEmployees
				.stream()
				.map(
						eEmployee->eEmployee.getEmployeeIdentity().getEmpname())
				.collect(Collectors.toList());
		return ResponseEntity.ok(allEmployeeNames);
	}
	public  ResponseEntity<List<Employee>> getEmpName(String id) {
		List<EEmployee> eEmployees= employeeRepository.findByEmployeeIdentityEmpid(id);
		if(eEmployees.isEmpty()) {
			System.out.println("empty");
			throw new EntityNotFoundException(id+"not found","id is invalid",HttpStatus.BAD_REQUEST);
			
		}	
		List<Employee> eEmployeeList=eEmployees
				.stream()
				.map(employeeTransformer.convertToEmployee())
				.collect(Collectors.toList());
		return ResponseEntity.ok(eEmployeeList);
	}
	
//	public Optional<?> getEmployee(EEmployeeIdentity eEmployeeIdentity) {
//		Optional<EEmployee> eemployee=employeeRepository.findById(eEmployeeIdentity);
//		List<Employee> employees=eemployee.stream().map(employeeTransformer.convertToEmployee())
//		.collect(Collectors.toList());
//		
//		return ResponseEntity.ok(employees);
//	}

}
