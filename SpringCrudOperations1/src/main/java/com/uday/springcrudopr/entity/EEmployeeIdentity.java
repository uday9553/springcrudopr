package com.uday.springcrudopr.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


import lombok.Data;
@Embeddable
@Data
public class EEmployeeIdentity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="empid")
	private String empid;
	
	@Column(name="empname")
	private String empname;
	
	@Column(name="locationcode")
	private String locationcode;
	
	
}