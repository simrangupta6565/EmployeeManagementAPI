package com.simran.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simran.employee.model.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department,Integer>{

}
