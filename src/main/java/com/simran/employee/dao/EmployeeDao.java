package com.simran.employee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simran.employee.model.Employee;


@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	@Query("select e from Employee e")
	public List<Employee> listAllEmployee();

}
