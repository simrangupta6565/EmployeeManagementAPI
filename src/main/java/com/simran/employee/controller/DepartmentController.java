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

import com.simran.employee.dao.DepartmentDao;
import com.simran.employee.model.Department;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentDao departmentDao;
	
	@PostMapping("/addDept")
	public String addDept(@RequestBody Department d) {
		departmentDao.save(d);
		return "Department Added......";
	}
	
	@GetMapping("/findAllDept")
	public List<Department> getAllDept(){
		return departmentDao.findAll();
	}
	
	@GetMapping("/getDept/{id}")
	public Department getDept(@PathVariable Integer id) {
		Department d = new Department();
		Optional<Department> opt = departmentDao.findById(id);
		if(!opt.isEmpty())
			d= opt.get();
		return d;
	}
	
	@DeleteMapping("/deleteDept")
	public String deleteDept(@RequestParam Integer id) {
		String msg ="Record not found";
		Department d = getDept(id);
		if(d.getDepartmentId()!=null) {
			departmentDao.delete(d);
			msg ="Department Deleted...";
		}
		return msg;
	}
//	@PutMapping("/updateDept")
//	public Department updateDept(@RequestBody Department d) {
//		Department d1 = getDept(d.getDepartmentId());
//		if(d.getDepartmentId()==null)
//			return d1;
//		else
//			return departmentDao.save(d);
//	}
}
