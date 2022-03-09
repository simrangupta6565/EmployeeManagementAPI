package com.simran.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simran.employee.dao.EmployeeDao;
import com.simran.employee.model.Employee;


@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDao ed;
	
	@PostMapping("/addEmployee")
	public String addRecord(@RequestBody Employee employee) {
			ed.save(employee);
			return "Employee Added......";
		}
	
	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee employee) {
		Employee emp = getEmployee(employee.getEmployeeId());
		if(emp== null) 
			return "Employee Not Found!";
		ed.save(employee);
		return "Employee Updated";
	}
	
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		Employee emp = null;
		Optional<Employee> opt = ed.findById(id);
		if(!opt.isEmpty())
			emp = opt.get();
		return emp;
	}

	@DeleteMapping("/deleteEmployee")
	public String deleteRecord(@RequestParam Integer employeeId) {
		Employee emp = getEmployee(employeeId);
		if(emp== null) 
			return "Employee Not Found!";
		ed.delete(emp);
		return "Employee Removed!";
	}
	
	@GetMapping("/findAllEmployee")
	public List<Employee> listAllEmployee() {
		return ed.listAllEmployee();
	}
}
