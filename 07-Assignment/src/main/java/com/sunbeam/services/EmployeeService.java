package com.sunbeam.services;

import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.EmployeeReqDto;
import com.sunbeam.dto.EmployeeRespDto;
import com.sunbeam.pojos.Employee;

public interface EmployeeService {
	ApiResponse addNewEmployee(EmployeeReqDto employee ); 
List<EmployeeRespDto> getAllEmployees();
ApiResponse updateEmployee(Employee employee);
Object deleteEmployee(Long EmpId);
EmployeeRespDto getEmployeeDetails(Long empId);
}
