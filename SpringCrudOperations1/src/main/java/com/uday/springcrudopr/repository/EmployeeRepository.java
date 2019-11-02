package com.uday.springcrudopr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uday.springcrudopr.entity.EEmployee;
import com.uday.springcrudopr.entity.EEmployeeIdentity;
@Repository
public interface EmployeeRepository extends JpaRepository<EEmployee, EEmployeeIdentity> {
	List<EEmployee> findByEmployeeIdentityEmpid(@Param(value="empid")String empid); 
	List<EEmployee> findByEmployeeIdentityEmpname(@Param(value="empname")String empname);
}
