package com.sunbeam.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeReqDto {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String location;
	private String department;
	private LocalDate joinDate;
	private double salary;
}
