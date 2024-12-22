package com.sunbeam.pojos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Employee extends BaseEntity{
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 30)
	private String email;
	@Column(length = 20)
	private String password;
	@Column(length = 50)
	private String location;
	@Column(length = 20)
	private String department;
	@Column
	private double salary;
	@Column(name="joining_date")
	private LocalDate joinDate;
	
	
}
