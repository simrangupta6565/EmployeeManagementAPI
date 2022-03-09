package com.simran.employee.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	@Column(unique=true)
	private String employeeUserName;
	private String employeePassword;
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("departmentId")
	@JoinColumn(name = "departmentId", insertable = true, updatable = true)
	private Department employeeDepartment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("departmentId")
	@JoinColumn(name = "gradeId", insertable = true, updatable = true)
	private Grade employeeGrade;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="EmployeeEmail")
	private EmployeeDetails details;
	public EmployeeDetails getDetails() {
		return details;
	}
	public void setDetails(EmployeeDetails details) {
		this.details = details;
	}
	public Department getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(Department employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	public Grade getEmployeeGrade() {
		return employeeGrade;
	}
	public void setEmployeeGrade(Grade employeeGrade) {
		this.employeeGrade = employeeGrade;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public String getEmployeeUserName() {
		return employeeUserName;
	}
	public void setEmployeeUserName(String employeeUserName) {
		this.employeeUserName = employeeUserName;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public void setEmployeeId(Integer employeeId2) {
		this.employeeId = employeeId2;
	}
	


}
