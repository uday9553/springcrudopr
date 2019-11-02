package com.uday.springcrudopr.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.uday.springcrudopr.model.util.SaveOrUpdate;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder

@JsonDeserialize(builder=Employee.EmployeeBuilder.class)
public class Employee {
  @JsonProperty
  @NotNull(groups={SaveOrUpdate.class} ,message="LocationCode should not be empty/null")
  @Size(groups={SaveOrUpdate.class}, min=3,message="LocationCode should be of length 3")
  private final String empid;
  @JsonProperty
  @NotNull(groups={SaveOrUpdate.class} ,message="empName should not be empty/null")
  @Size(groups={SaveOrUpdate.class},min = 3 ,message="empName should be of length 3 ")
  private final String empname;
  @JsonProperty
  @NotNull(groups={SaveOrUpdate.class} ,message="RouteNumber should not be empty/null")
  private final String location;
  @JsonProperty 
  @NotNull(groups={SaveOrUpdate.class} ,message="Printer Ip should not be empty/null")
  private final String locationcode;
  @JsonProperty
  @NotNull(message="LastModifiedDate should be empty/null")
  //@JsonSerialize(converter=LocalDateSerializer.class)
  private final  String date;
  @JsonProperty
  @NotNull(message="ModifiedID should be empty/null")
  private final String salary;
  
  @JsonPOJOBuilder(buildMethodName="build",withPrefix="")
  public static class EmployeeBuilder{
	  
  }
 
}
