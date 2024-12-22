package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.EmployeeReqDto;
import com.sunbeam.dto.EmployeeRespDto;
import com.sunbeam.pojos.Employee;
import com.sunbeam.services.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	
	public EmployeeController() {
		System.out.println("in ctor"+getClass());
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getEmployee(){
		System.out.println("get all");
		List<EmployeeRespDto> employees=empService.getAllEmployees();
		if(employees.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		}
		return ResponseEntity.ok(employees);
	}
	
@PostMapping("/")
public ResponseEntity<?> addNewEmployee(@RequestBody EmployeeReqDto employee){
	System.out.println("in add emp"+employee);
	
	return ResponseEntity.status(HttpStatus.CREATED).body(empService.addNewEmployee(employee));
	
}
@GetMapping("/{empId}")
public ResponseEntity<?> getEmployeeDetails(@PathVariable Long empId) {
	System.out.println("in get dtls " + empId);
	try {
		
		EmployeeRespDto employee = empService.getEmployeeDetails(empId);
		return ResponseEntity.ok(employee);
	} catch (RuntimeException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
	}
}

@PutMapping("/")
public ResponseEntity<?> updateEmployeeDetails(@RequestBody Employee employee) {


	
	return ResponseEntity.ok(
			empService.updateEmployee(employee));

}

@DeleteMapping("/{empId}")
public ResponseEntity<?> deleteEmployee(@PathVariable() Long empId)
{
	System.out.println("in delete "+empId);
	try {
		//invoke service layer method
		return ResponseEntity.ok(
		empService.deleteEmployee(empId));
	} catch (RuntimeException e) {
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(new ApiResponse(e.getMessage()));
	}
}

	
	

	

}
