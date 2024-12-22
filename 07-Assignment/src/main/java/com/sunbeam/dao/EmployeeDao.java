package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.pojos.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long>{
	

}
