package com.simran.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.simran.employee.dao.GradeDao;
import com.simran.employee.model.Grade;

@RestController
public class GradeController {
	@Autowired
	private GradeDao gd; 
	
	@GetMapping("/findAllGrade")
	public List<Grade> findAll() {
		return gd.listAllGrade();
	}

	@PostMapping("/addGrade")
	public String addGrade(@RequestBody Grade g) {
		gd.save(g);
		return "Grade Added......";
	}
	@DeleteMapping("/deleteGrade")
	public String deleteGrade(@RequestParam Integer gradeId) {
		Grade g = getGrade(gradeId);
		if(g== null) 
			return "Grade Not Found!";
		gd.delete(g);
		return "Employee Removed!";
	}
	@GetMapping("/getGrade/{id}")
	public Grade getGrade(@PathVariable Integer gradeId) {
		Grade g = null;
		Optional<Grade> opt = gd.findById(gradeId);
		if(!opt.isEmpty())
			g = opt.get();
		return g;
	}
}
