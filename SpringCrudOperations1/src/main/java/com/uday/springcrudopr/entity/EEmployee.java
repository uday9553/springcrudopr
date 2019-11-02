package com.uday.springcrudopr.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="eemployee")
@Data
public class EEmployee {
	
	@EmbeddedId
	private EEmployeeIdentity employeeIdentity;
	
	@Column(name="location")
	private String location;
	
	@Column(name="date")
	private String date;
	
	@Column(name="salary")
	private String salary;

}
