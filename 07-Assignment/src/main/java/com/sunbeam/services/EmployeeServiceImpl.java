package com.sunbeam.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.EmployeeDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.EmployeeReqDto;
import com.sunbeam.dto.EmployeeRespDto;
import com.sunbeam.exceptions.ResourceNotFoundException;
import com.sunbeam.pojos.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao empDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ApiResponse addNewEmployee(EmployeeReqDto dto) {
		Employee empEntity=modelMapper.map(dto, Employee.class);
		Employee persistentEmployee=empDao.save(empEntity);
		
		
		return new ApiResponse("Added new Category with Id= "+persistentEmployee.getId());
	}

	@Override
	public List<EmployeeRespDto> getAllEmployees() {
		
		return empDao.findAll().stream().map(employee->modelMapper.map(employee, EmployeeRespDto.class)).collect(Collectors.toList());
	}

	@Override
	public ApiResponse updateEmployee(Employee employee) {
		if(empDao.existsById(employee.getId())){
			empDao.save(employee);
		}
		return new ApiResponse("Employee Updated");
	}

	@Override
	public Object deleteEmployee(Long EmpId) {
		if(empDao.existsById(EmpId)) {
			empDao.deleteById(EmpId);
			return new ApiResponse("Employee DEleted");
		}
		return new ResourceNotFoundException("Invalid Category ID !!!!!!!!");
	}

	@Override
	public EmployeeRespDto getEmployeeDetails(Long empId) {
	Employee empEntity=empDao.findById(empId).orElseThrow(()->new ResourceNotFoundException("Invalid Emp Id"));
		return modelMapper.map(empEntity, EmployeeRespDto.class);
	}

}
