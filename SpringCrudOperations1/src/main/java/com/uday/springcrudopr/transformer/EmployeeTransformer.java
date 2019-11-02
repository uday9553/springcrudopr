package com.uday.springcrudopr.transformer;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.uday.springcrudopr.entity.EEmployee;
import com.uday.springcrudopr.entity.EEmployeeIdentity;
import com.uday.springcrudopr.model.Employee;

@Component
public class EmployeeTransformer {
	public Function<EEmployee, Employee> convertToEmployee(){
		Function<EEmployee, Employee> mapper=(EEmployee eEmployee)->{
			Employee employee=Employee.builder()
					.empid(eEmployee.getEmployeeIdentity().getEmpid())
					.empname(eEmployee.getEmployeeIdentity().getEmpname())
					.locationcode(eEmployee.getEmployeeIdentity().getLocationcode())
					.location(eEmployee.getLocation())
					.date(eEmployee.getDate())
					.salary(eEmployee.getSalary())
					.build();
			return employee;
		};
		return mapper;
	}
	
	public Function<Employee, EEmployee> convertToEEmployee(){
		Function<Employee, EEmployee> mapper=(Employee employee)->{
			EEmployee eEmployee=new EEmployee();
			EEmployeeIdentity eEmployeeIdentity=new EEmployeeIdentity();
			eEmployeeIdentity.setEmpid(employee.getEmpid());
			eEmployeeIdentity.setEmpname(employee.getEmpname());
			eEmployeeIdentity.setLocationcode(employee.getLocationcode());
			eEmployee.setLocation(employee.getLocation());
			eEmployee.setDate(employee.getDate());
			eEmployee.setSalary(employee.getSalary());
			return eEmployee;
		};
		return mapper;
	}
}
